package com.softgroup.authorization.api.service;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.message.RegisterRequest;

/**
 * Created by user on 30.07.2017.
 */
public interface AuthorizationService {
    Boolean checkPhoneNumber(String phoneNumber);

    String clearPhoneNumber(String phoneNumber);

    Boolean checkLocaleCode(String locale);

    boolean isPhoneNumberInQuantityLimiter(String phone);

    void addDataToConfirmationRegisterCache(ConfirmationRegisterData data);

    void addPhoneNumberToSmsQuantityLimiterCache(String phone,String registrationRequestUUID);

    String getUUIDFromPhone(String phoneNumber);

    ConfirmationRegisterData getRegisterDataFromPhoneNumber(String phoneNumber);

    Integer calculateRegistrationTimeout(ConfirmationRegisterData data);

    Boolean checkVerificationCode(String registrationRequestUUID, String confirmationCode);

    RegisterRequest popRecordFromCache(String registrationRequestUUID);

    String createProfileIfNotExist(String phoneNumber, String locale);

    String createDeviceIfNotExist(String profileId, String deviceId);

    String generateDeviceToken(String profileId, String deviceId);
}
