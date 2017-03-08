package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

	@Autowired
	private List<T> handlers;
	private Map<String,T> handlerMap = new HashMap<String, T>();

	public abstract String getName();

	@Override
	public abstract String getRouteKey(Request<?> msg) ;

	@Override
	public Response<?> handle(Request<?> msg) {
		T handler = handlerMap.get(getRouteKey(msg));
		return handler.handle(msg);
	}


	@PostConstruct
	public void init () {
		for (T handler:handlers) {
			handlerMap.put(handler.getName(),handler);
		}
	}
}
