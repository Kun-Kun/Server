package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

/**
 * Created by maxim on 06.03.17.
 */
public class CommandHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> implements HandlerFactory{

    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}
