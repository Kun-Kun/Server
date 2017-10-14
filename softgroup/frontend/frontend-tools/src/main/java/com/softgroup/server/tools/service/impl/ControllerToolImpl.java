package com.softgroup.server.tools.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.common.protocol.RoutingData;
import com.softgroup.server.tools.service.ControllerTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import com.softgroup.token.api.JwtUserIdentifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by user on 07.04.2017.
 */
@Service
public class ControllerToolImpl implements ControllerTool {

    @Autowired
    private DataMapper dataMapper;

    public Request<LinkedHashMap> parseRequestFromJson(String json){
        return dataMapper.mapData(json, new TypeReference<Request<HashMap>>() {});
    }

    public Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request, JwtUserIdentifier userIdentifier){

        RoutingData routingData = null;
        if(userIdentifier!=null){
             routingData  = buildRoutingData(userIdentifier);
        }

        return new RequestBuilder<LinkedHashMap>()
                .setData(request.getData())
                .setHeader(request.getHeader())
                .setRoutingData(routingData)
                .build();
    }
    public Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request) {
        JwtUserIdentifier userIdentifier = (JwtUserIdentifier) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return setRoutingData(request, userIdentifier);
    }

    @Override
    public Map<String, Object> convertToMap(String textMessage) {
        return  dataMapper.convertToMap(textMessage);

    }

    public Map<String,Object> parseMapFromJson(String json){
        return dataMapper.mapData(json, new TypeReference<HashMap<String,Object>>() {});
    }

    public String dataToString(Object o){
        return dataMapper.dataToString(o);
    }

    private RoutingData buildRoutingData(JwtUserIdentifier userIdentifier){
        RoutingData data = new RoutingData();
        data.setDeviceId(userIdentifier.getDeviceId());
        data.setUserId(userIdentifier.getUserId());
        return data;
    }

}
