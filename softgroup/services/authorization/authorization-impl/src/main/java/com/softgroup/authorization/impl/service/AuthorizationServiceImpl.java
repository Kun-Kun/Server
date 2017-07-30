package com.softgroup.authorization.impl.service;

import com.softgroup.authorization.api.service.AuthorizationService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.07.2017.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

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


}
