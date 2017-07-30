package com.softgroup.common.utilites;

/**
 * Created by user on 09.04.2017.
 */
public enum ResponseStatusCode {

    OK(200,"Ok"),

    BAD_REQUEST(400,"Bad request"),
    FORBIDDEN(403,"Forbidden"),
    NOT_FOUND(404,"Not found"),
    NOT_ACCEPTABLE(406,"Not acceptable"),
    UNPROCESSABLE_ENTITY(422,"Unprocessable Entity"),
    TOO_MANY_REQUESTS(429,"Too many requests"),

    INTERNAL_SERVER_ERROR(500,"Internal server error"),
    NOT_IMPLEMENTED(501,"Not implemented");

    private Integer code;
    private String message;

   ResponseStatusCode(Integer code, String message){
       this.code=code;
       this.message = message;
   }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
