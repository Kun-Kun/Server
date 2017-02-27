package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Created by user on 24.02.2017.
 */
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequest,LoginResponse>  implements AuthorizationRequestHandler{

    public String getName(){
        return "login";
    }

    @Override
    public Response<LoginResponse> handle(Request<?> msg) {
        Response<LoginResponse> response = new Response<LoginResponse>();
        response.setData(new LoginResponse());
        return response;
    }

}
