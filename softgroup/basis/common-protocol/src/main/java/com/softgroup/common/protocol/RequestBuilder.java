package com.softgroup.common.protocol;

/**
 * Created by user on 12.03.2017.
 */
public class RequestBuilder<T extends Serializable> {

    private Request<T> request = new Request<>();

    public RequestBuilder<T> setHeader(ActionHeader header){
        request.setHeader(header);
        return this;
    }

    public RequestBuilder<T> setData(T data){
        request.setData(data);
        return this;
    }

    public RequestBuilder<T> setRoutingData(RoutingData data){
        request.setRoutingData(data);
        return this;
    }

    public Request<T> build(){
        return request;
    }
}
