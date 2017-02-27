package com.softgroup.common.router.api;


import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

public class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {
	@Override
	public String getName() {
		return null;
	}

	@Override
	public Response<R> handle(Request<?> msg) {
		return null;
	}

}
