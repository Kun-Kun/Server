package com.softgroup.common.exceptions;

/**
 * Created by user on 03.04.2017.
 */
public class TokenException extends SoftgroupException {
    private static final long serialVersionUID = 1515849547329185210L;

    public TokenException(String msg){
        super(msg);
    }
    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
