package com.softgroup.common.protocol;

import java.io.Serializable;

/**
 * Created by user on 12.03.2017.
 */
public class RequestBuilder<T extends RequestData> {

    private Request<T> request = new Request<T>();

    public RequestBuilder<T> setHeader(ActionHeader header){
        request.setHeader(header);
        return this;
    }

    public RequestBuilder<T> setData(T data){
        request.setData(data);
        return this;
    }

    public Request<T> build(){
        return request;
    }
}
