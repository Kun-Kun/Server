package com.softgroup.common.utilites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtherUtils {
    public static Boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^\\+[0-9]{12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static String clearPhoneNumber(String phoneNumber){
        return phoneNumber.replaceAll("[- )(]","");
    }

}
