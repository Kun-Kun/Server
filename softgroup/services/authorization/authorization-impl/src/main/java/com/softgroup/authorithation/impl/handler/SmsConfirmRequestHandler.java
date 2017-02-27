package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Created by user on 25.02.2017.
 */

    public class SmsConfirmRequestHandler extends AbstractRequestHandler<SmsConfirmRequest,SmsConfirmResponse> implements AuthorizationRequestHandler {

    public String getName(){
            return "sms_confirm";
        }

    @Override
    public Response<SmsConfirmResponse> handle(Request<?> msg) {
        Response<SmsConfirmResponse> response = new Response<SmsConfirmResponse>();
        response.setData(new SmsConfirmResponse());
        return response;
    }

    }

