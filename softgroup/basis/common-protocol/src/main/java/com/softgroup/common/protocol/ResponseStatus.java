package com.softgroup.common.protocol;

import java.io.Serializable;

public class ResponseStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
