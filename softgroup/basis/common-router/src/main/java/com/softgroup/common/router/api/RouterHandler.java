package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

public interface RouterHandler extends Handler {

	String getRouteKey(final Request<?> msg);
}
