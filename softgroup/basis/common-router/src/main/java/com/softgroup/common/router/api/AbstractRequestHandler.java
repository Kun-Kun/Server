package com.softgroup.common.router.api;


import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public abstract class AbstractRequestHandler<RQ extends RequestData, RS extends ResponseData> implements RequestHandler {

	@Autowired
	DataMapper dataMapper;

	@Override
	public Response<RS> handle(Request<?> msg) {
		Request<RQ> typedRequest = toType(msg);
		Response<RS> response = processRequest(typedRequest);
		return response;
	}


	private  Request<RQ> toType(Request<?> msg ){
		Object dataObject = msg.getData();
		Map<String,Object> map =  dataMapper.convertToMap(dataObject);
		RQ requestData = dataMapper.convert(map, new TypeReference<RQ>() {});
		return new RequestBuilder<RQ>().setData(requestData).setHeader(msg.getHeader()).build();
	}

	public abstract Response<RS> processRequest(Request<RQ> msg);
}
