package com.softgroup.server.rest.service;

import com.softgroup.common.protocol.Request;

import java.util.LinkedHashMap;

/**
 * Created by user on 07.04.2017.
 */
public interface ControllerToolService {

    Request<LinkedHashMap> parseRequestFromJson(String json);

    Request<LinkedHashMap> setRoutingData(Request<LinkedHashMap> request);

    }
