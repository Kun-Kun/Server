package com.softgroup.authorization.api.cache;

import com.softgroup.authorization.api.message.RegisterRequest;

import java.util.UUID;

/**
 * Created by user on 13.04.2017.
 */
public class ConfirmationRegisterData {
    private String registrationRequestUUID;

    private String confirmationCode;

    private RegisterRequest request;

    public ConfirmationRegisterData(RegisterRequest request) {
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

    private String generateUUID(){
        return UUID.randomUUID().toString();
    }

    private String generateConfirmationCode(){
        return UUID.randomUUID().toString().substring(0,5);
    }

}
