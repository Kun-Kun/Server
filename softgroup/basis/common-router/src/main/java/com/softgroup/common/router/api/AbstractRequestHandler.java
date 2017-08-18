package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public abstract class AbstractRequestHandler<RQ extends RequestData, RS extends ResponseData> implements RequestHandler {

	@Autowired
	private DataMapper dataMapper;

	@Override
	public Response<RS> handle(Request<?> msg) {
		Request<RQ> typedRequest = toType(msg);
		return processRequest(typedRequest);
	}


	private  Request<RQ> toType(Request<?> msg ){
		Map<String,Object> map = (Map<String,Object>) msg.getData();

		RQ requestData = dataMapper.convert(map, getRequestDataClass());
		return new RequestBuilder<RQ>().setData(requestData).setHeader(msg.getHeader()).setRoutingData(msg.getRoutingData()).build();
	}

	public abstract Class<RQ> getRequestDataClass();


	public abstract Response<RS> processRequest(Request<RQ> msg);
}
