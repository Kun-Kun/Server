package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
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
 * Created by user on 25.02.2017.
 */
@Component
public class SmsConfirmRequestHandler extends AbstractRequestHandler<SmsConfirmRequest,SmsConfirmResponse> implements AuthorizationRequestHandler {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public String getName(){
            return "sms_confirm";
        }

    @Override
    public Class<SmsConfirmRequest> getRequestDataClass() {
        return SmsConfirmRequest.class;
    }

    @Override
    public Response<SmsConfirmResponse> processRequest(Request<SmsConfirmRequest> msg){
        SmsConfirmRequest smsConfirmRequest = msg.getData();
        String registrationRequestUUID = smsConfirmRequest.getRegistrationRequestUuid();
        String confirmationCode = smsConfirmRequest.getAuthCode();
        if (authorizationService.checkVerificationCode(registrationRequestUUID, confirmationCode)){
            RegisterRequest request = authorizationService.popRecordFromCache(registrationRequestUUID);

            String phoneNumber = request.getPhoneNumber();
            String deviceIdFromUser = request.getDeviceId();
            String localeCode = request.getLocaleCode();

            String profileId = authorizationService.createProfileIfNotExist(phoneNumber,localeCode);
            String deviceDatabaseId = authorizationService.createDeviceIfNotExist(profileId,deviceIdFromUser);

            String deviceToken = authorizationService.generateDeviceToken(profileId, deviceDatabaseId);

            SmsConfirmResponse smsConfirmResponse = new SmsConfirmResponse();
            smsConfirmResponse.setDeviceToken(deviceToken);
            return ResponseUtils.createOKResponse(msg,smsConfirmResponse);
        }else {
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.NOT_ACCEPTABLE,"Pair of verificationCode and registrationRequestUUID is invalid");
        }

    }

}

