package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.service.AuthorizationService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 24.02.2017.
 */
@Component
public class RegisterRequestHandler extends AbstractRequestHandler<RegisterRequest,RegisterResponse> implements AuthorizationRequestHandler {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public String getName(){
        return "register";
    }

    @Override
    public Class<RegisterRequest> getRequestDataClass() {
        return RegisterRequest.class;
    }

    @Override
    public Response<RegisterResponse> processRequest(Request<RegisterRequest> msg){
        if(!authorizationService.checkLocaleCode(msg.getData().getLocaleCode())){
            return  ResponseUtils.createCustomResponse(msg, ResponseStatusCode.BAD_REQUEST,"Unknown Locale");
        }
        return null;
    }

}