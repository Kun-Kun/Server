package com.softgroup.common.sms;

/**
 * Created by user on 14.04.2017.
 */
public interface SmsService {

    void send(String number,String message);
}
