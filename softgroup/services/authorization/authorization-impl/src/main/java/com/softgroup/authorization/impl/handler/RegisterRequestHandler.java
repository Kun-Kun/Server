package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 24.02.2017.
 */
@Component
public class RegisterRequestHandler extends AbstractRequestHandler<RegisterRequest,RegisterResponse> implements AuthorizationRequestHandler {

    public String getName(){
        return "register";
    }

    @Override
    public Response<RegisterResponse> processRequest(Request<RegisterRequest> msg){
        return null;
    }

}