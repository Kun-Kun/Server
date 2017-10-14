package com.softgroup.server.socket.filter.impl;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import com.softgroup.filter.api.AllowAuthorizationRequestBorderFilterHandler;
import com.softgroup.server.socket.filter.SocketRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 07.10.2017.
 */
@Component
public class SocketRouterHandlerImpl implements Handler, SocketRouterHandler {

    @Autowired
    private AllowAuthorizationRequestBorderFilterHandler allowAuthorizationRequestHandler;

    @Autowired
    private TypeRouterHandler typeRouterHandler;

    @Override
    public String getName() {
        return "socketFilterHandler";
    }

    @Override
    public Response handle(Request<?> msg) {
        if(msg.getRoutingData()==null){
            return allowAuthorizationRequestHandler.handle(msg);
        }else
            return typeRouterHandler.handle(msg);
    }
}
