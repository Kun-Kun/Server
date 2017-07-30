package com.softgroup.common.protocol;


/**
 * Created by user on 12.03.2017.
 */
public class ResponseBuilder<T extends ResponseData> {

    private Response<T> response = new Response<>();

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

    public ResponseBuilder<T> setRoutingData(RoutingData data){
        response.setRoutingData(data);
        return this;
    }

    public Response<T> build(){
        return response;
    }
}
