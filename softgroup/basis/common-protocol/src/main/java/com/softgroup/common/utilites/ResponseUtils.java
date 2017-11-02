package com.softgroup.common.utilites;

import com.softgroup.common.protocol.*;

import java.util.UUID;

/**
 * Created by user on 09.04.2017.
 */
public class ResponseUtils {

    private ResponseUtils() {
    }

    public static <T extends ResponseData> Response<T> createResponseFromRequest(Request<?> request, ResponseStatus status, T data){
         return new ResponseBuilder<T>()
                 .setData(data)
                 .setHeader(makeNewHeader(request.getHeader()))
                 .setStatus(status).build();
    }

    public static <T extends ResponseData> Response<T> createResponseFromRequest(Request<?> request, ResponseStatusCode status, T data){
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setMessage(status.getMessage());
        responseStatus.setCode(status.getCode());

        return createResponseFromRequest(request,responseStatus,data);
    }

    public static <T extends ResponseData> Response<T> createOKResponse(Request<?> request, T data){
        return createResponseFromRequest(request, ResponseStatusCode.OK, data);
    }

    public static <T extends ResponseData> Response<T> createBadRequestResponse(Request<?> request){
        return createResponseFromRequest(request, ResponseStatusCode.BAD_REQUEST, null);
    }

    public static <T extends ResponseData> Response<T> createErrorResponse(Request<?> request,ResponseStatusCode code){
        if(code.equals(ResponseStatusCode.OK)){
            throw new IllegalArgumentException("Error response can not have OK(200) code with empty data. You must use createOKResponse method.");
        }
        return createResponseFromRequest(request, code, null);
    }

    public static <T extends ResponseData> Response<T> createCustomResponse(Request<?> request,Integer code, String message){
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setMessage(message);
        responseStatus.setCode(code);
        return createResponseFromRequest(request,responseStatus,null);
    }

    public static <T extends ResponseData> Response<T> createCustomResponse(Request<?> request,ResponseStatusCode status, String additionMessage){
        return createCustomResponse(request, status.getCode(), status.getMessage()+". "+ additionMessage);
    }

    private static ActionHeader makeNewHeader(ActionHeader header){
        ActionHeader newHeader = new ActionHeader();
        newHeader.setType(header.getType());
        newHeader.setCommand(header.getCommand());
        newHeader.setVersion(header.getVersion());
        newHeader.setOriginUuid(header.getUuid());
        newHeader.setUuid(UUID.randomUUID().toString());
        return newHeader;
    }

}
