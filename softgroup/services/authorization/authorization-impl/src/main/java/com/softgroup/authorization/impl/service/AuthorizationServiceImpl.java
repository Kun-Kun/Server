package com.softgroup.authorization.impl.service;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.cache.PhoneNumberUUIDCache;
import com.softgroup.authorization.api.cache.SmsQuantityLimiterCache;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.service.AuthorizationService;
import com.softgroup.common.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.07.2017.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    private ConfirmationRegisterCache confirmationRegisterCache;

    @Autowired
    private SmsQuantityLimiterCache smsQuantityLimiterCache;

    @Autowired
    private PhoneNumberUUIDCache phoneNumberUUIDCache;

    @Autowired
    private SmsService smsService;

    public Boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^\\+?[0-9]{12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public String clearPhoneNumber(String phoneNumber){
        return phoneNumber.replaceAll("[- )(]","");
    }

    //Now only available only Ukrainian locale
    public Boolean checkLocaleCode(String locale){
        return "uk_UA".equals(locale);
    }

    public boolean isPhoneNumberInQuantityLimiter(String phone){
        return smsQuantityLimiterCache.isInDatabase(phone);
    }

    public void addDataToConfirmationRegisterCache(ConfirmationRegisterData data){
        confirmationRegisterCache.put(data.getRegistrationRequestUUID(),data);
        String phoneNumber = clearPhoneNumber(data.getRequest().getPhoneNumber());
        phoneNumberUUIDCache.put(phoneNumber,data.getRegistrationRequestUUID());
    }

    public void addPhoneNumberToSmsQuantityLimiterCache(String phone,String registrationRequestUUID){
        smsQuantityLimiterCache.put(phone,registrationRequestUUID);
    }

    public String getUUIDFromPhone(String phoneNumber){
        return phoneNumberUUIDCache.get(phoneNumber);
    }

    //Return ConfirmationRegisterData if present in cache, else return null
    public ConfirmationRegisterData getRegisterDataFromPhoneNumber(String phoneNumber){
        String uuid = getUUIDFromPhone(phoneNumber);
        if (uuid==null){
            return null;
        }
        return confirmationRegisterCache.get(uuid);
    }

    public Integer calculateRegistrationTimeout(ConfirmationRegisterData data){
        Long requestTime = new Date().getTime();
        Long timeToTimeout = confirmationRegisterCache.getTimeoutTime();
        Long timeoutMs = data.getCreateTime()+timeToTimeout-requestTime;
        return (int)TimeUnit.MILLISECONDS.toSeconds(timeoutMs);
    }
}
