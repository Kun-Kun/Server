package com.softgroup.router.type.router.api;


import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.RequestHandler;
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
		RQ requestData = dataMapper.convert(map, new TypeReference<RQ>() {});
		return new RequestBuilder<RQ>().setData(requestData).setHeader(msg.getHeader()).build();
	}

	public abstract Response<RS> processRequest(Request<RQ> msg);
}