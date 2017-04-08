package com.softgroup.server.rest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.common.protocol.RoutingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import com.softgroup.token.api.JwtUserIdentifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by user on 07.04.2017.
 */
@Service
public class RestTool implements RestToolService{

    @Autowired
    private DataMapper dataMapper;

    public Request<LinkedHashMap> parseRequestFromJson(String json){
        return dataMapper.mapData(json, new TypeReference<Request<HashMap>>() {});
    }

    public Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request){
        JwtUserIdentifier userIdentifier = (JwtUserIdentifier) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new RequestBuilder<LinkedHashMap>()
                .setData(request.getData())
                .setHeader(request.getHeader())
                .setRoutingData(buildRoutingData(userIdentifier))
                .build();
    }

    private RoutingData buildRoutingData(JwtUserIdentifier userIdentifier){
        RoutingData data = new RoutingData();
        data.setDeviceId(userIdentifier.getDeviceId());
        data.setUserId(userIdentifier.getUserId());
        return data;
    }
}
