package com.softgroup.authorization.api.service;

/**
 * Created by user on 30.07.2017.
 */
public interface AuthorizationService {
    Boolean checkPhoneNumber(String phoneNumber);

    String clearPhoneNumber(String phoneNumber);

    Boolean checkLocaleCode(String locale);
}
