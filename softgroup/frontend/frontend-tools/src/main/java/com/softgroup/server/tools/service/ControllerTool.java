package com.softgroup.server.tools.service;

import com.softgroup.common.protocol.Request;
import com.softgroup.token.api.JwtUserIdentifier;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by user on 07.04.2017.
 */
public interface ControllerTool {

    Request<LinkedHashMap> parseRequestFromJson(String json);

    Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request);

    Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request, JwtUserIdentifier userIdentifier);

    Map<String,Object> convertToMap(String textMessage);

    Map<String,Object> parseMapFromJson(String json);

    String dataToString(Object o);

}
