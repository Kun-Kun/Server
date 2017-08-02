package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.service.AuthorizationService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
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
            return  ResponseUtils.createCustomResponse(msg, ResponseStatusCode.BAD_REQUEST,"Unknown locale");
        }
        String clearedPhoneNumber = authorizationService.clearPhoneNumber(msg.getData().getPhoneNumber());
        if(!authorizationService.checkPhoneNumber(clearedPhoneNumber)){
            return  ResponseUtils.createCustomResponse(msg, ResponseStatusCode.BAD_REQUEST,"Invalid phone number format");
        }

        if (authorizationService.isPhoneNumberInQuantityLimiter(clearedPhoneNumber)){
            return  ResponseUtils.createCustomResponse(msg, ResponseStatusCode.TOO_MANY_REQUESTS,"The message with the code is sent no more often than once in 3 minutes");
        }

        ConfirmationRegisterData data = authorizationService.getRegisterDataFromPhoneNumber(clearedPhoneNumber);
        if (data ==null){
            data = new ConfirmationRegisterData(msg.getData());
            authorizationService.addDataToConfirmationRegisterCache(data);
        }

        authorizationService.addPhoneNumberToSmsQuantityLimiterCache(clearedPhoneNumber,data.getRegistrationRequestUUID());

        RegisterResponse responseData = new RegisterResponse();
        responseData.setRegistrationRequestUuid(data.getRegistrationRequestUUID());
        //ToDo remove AuthCode in response and send it via sms
        responseData.setAuthCode(data.getConfirmationCode());
        Integer timeout = authorizationService.calculateRegistrationTimeout(data);
        responseData.setRegistrationTimeoutSec(timeout);
        return ResponseUtils.createOKResponse(msg,responseData);
    }

}