package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Created by user on 24.02.2017.
 */
public class RegisterRequestHandler extends AbstractRequestHandler<RegisterRequest,RegisterResponse> implements AuthorizationRequestHandler {

    public String getName(){
        return "register";
    }

    @Override
    public Response<RegisterResponse> handle(Request<?> msg) {
        Response<RegisterResponse> response = new Response<RegisterResponse>();
        response.setData(new RegisterResponse());
        return response;
    }

}