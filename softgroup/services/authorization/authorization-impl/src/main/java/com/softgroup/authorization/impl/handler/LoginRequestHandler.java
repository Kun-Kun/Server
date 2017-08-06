package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.service.AuthorizationService;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 24.02.2017.
 */
@Component
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequest,LoginResponse>  implements AuthorizationRequestHandler{

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public String getName(){
        return "login";
    }

    @Override
    public Class<LoginRequest> getRequestDataClass() {
        return LoginRequest.class;
    }

    @Override
    public Response<LoginResponse> processRequest(Request<LoginRequest> msg){
        String deviceToken = msg.getData().getDeviceToken();

        if (authorizationService.validateDeviceToken(deviceToken)){
            LoginResponse response = new LoginResponse();
            response.setToken(authorizationService.generateToken(deviceToken));
            return ResponseUtils.createOKResponse(msg, response);
        }else {
            return ResponseUtils.createCustomResponse(msg,ResponseStatusCode.NOT_ACCEPTABLE,"Token is invalid");
        }
    }
}
