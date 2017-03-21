package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenType;

/**
 * Created by user on 18.03.2017.
 */
public class KeyFactory {
    //key for long term token
    private String keyLT = "kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9";
    //key for short term token
    private String keyST = "AMVvu8OMlipxmr8l73Eo9NXlA5AVNJr1";

    public String getKey(TokenType type){
        switch (type){
            case LONG_TERM:
                return keyLT;
            case SHORT_TERM:
                return keyST;
            default:return null;
        }
    }
}
