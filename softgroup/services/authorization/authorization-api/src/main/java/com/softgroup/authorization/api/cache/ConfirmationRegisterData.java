package com.softgroup.authorization.api.cache;

import com.softgroup.authorization.api.message.RegisterRequest;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 13.04.2017.
 */
public class ConfirmationRegisterData {
    private final String registrationRequestUUID;

    private final String confirmationCode;

    private final Long createTime;

    private RegisterRequest request;


    public ConfirmationRegisterData(RegisterRequest request) {
        this.createTime = new Date().getTime();
        this.request = request;
        this.registrationRequestUUID = generateUUID();
        this.confirmationCode = generateConfirmationCode();
    }

    public RegisterRequest getRequest() {
        return request;
    }

    public String getRegistrationRequestUUID() {
        return registrationRequestUUID;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public Long getCreateTime() {
        return createTime;
    }

    private String generateUUID(){
        return UUID.randomUUID().toString();
    }

    private String generateConfirmationCode(){
        return UUID.randomUUID().toString().substring(0,5);
    }

}
