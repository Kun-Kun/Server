package com.softgroup.common.protocol;

import java.io.Serializable;

public class RoutedAction<T extends Serializable> extends Action<T> {
	private static final long serialVersionUID = -318012176965757271L;

	private RoutingData routingData;

	public RoutingData getRoutingData() {
		return routingData;
	}

	public void setRoutingData(RoutingData routingData) {
		this.routingData = routingData;
	}
}
