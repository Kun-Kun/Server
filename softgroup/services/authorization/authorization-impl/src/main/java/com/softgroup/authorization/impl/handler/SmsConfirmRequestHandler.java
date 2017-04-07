package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 25.02.2017.
 */
    @Component
    public class SmsConfirmRequestHandler extends AbstractRequestHandler<SmsConfirmRequest,SmsConfirmResponse> implements AuthorizationRequestHandler {

    public String getName(){
            return "sms_confirm";
        }

    @Override
    public Class<SmsConfirmRequest> getRequestDataClass() {
        return SmsConfirmRequest.class;
    }

    @Override
    public Response<SmsConfirmResponse> processRequest(Request<SmsConfirmRequest> msg){
        return null;
    }

    }

