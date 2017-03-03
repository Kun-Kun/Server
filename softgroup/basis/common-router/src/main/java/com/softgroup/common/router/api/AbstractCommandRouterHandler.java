package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

/**
 * Created by user on 26.02.2017.
 */
public abstract class AbstractCommandRouterHandler<T extends Handler> extends AbstractRouterHandler<T>{

    @Override
    public abstract String getName();

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}
