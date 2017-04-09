package com.softgroup.common.router.api;

import com.softgroup.common.factory.HandlerFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.utilites.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends HandlerFactory> implements RouterHandler {

	@Autowired
	private T factory;

	@Override
	public Response<?> handle(Request<?> msg) {
		Handler handler = factory.getHandler(msg);
		if (handler == null){
			return ResponseUtils.createBadRequestResponse(msg);
		}
		return handler.handle(msg);
	}

}
