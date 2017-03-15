package com.softgroup.common.protocol;

import java.io.Serializable;

/**
 * Created by user on 12.03.2017.
 */
public class ResponseBuilder<T extends Serializable> {

    private Response<T> response = new Response<T>();

    public ResponseBuilder<T> setHeader(ActionHeader header){
        response.setHeader(header);
        return this;
    }

    public ResponseBuilder<T> setData(T data){
        response.setData(data);
        return this;
    }

    public ResponseBuilder<T> setStatus(ResponseStatus status){
        response.setStatus(status);
        return this;
    }

    public Response build(){
        return response;
    }
}
