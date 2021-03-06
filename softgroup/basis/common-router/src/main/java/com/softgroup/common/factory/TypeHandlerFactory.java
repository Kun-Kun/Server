package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

/**
 * Created by user on 06.03.2017.
 */
public class TypeHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> implements HandlerFactory{

    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }
}