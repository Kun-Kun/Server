package com.softgroup.server.rest.controller;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.filter.api.AllowAuthorizationRequestBorderFilterHandler;
import com.softgroup.server.rest.service.ControllerToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

/**
 * Created by user on 26.03.2017.
 */

@RestController
@RequestMapping(value = "/api")
public class PublicController {

    @Autowired
    private AllowAuthorizationRequestBorderFilterHandler allowAuthorizationRequestBorderFilterHandler;

    @Autowired
    private ControllerToolService controllerTool;

    @RequestMapping(value = "/public",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response publicController(@RequestParam String data) {
       Request<LinkedHashMap> request = controllerTool.parseRequestFromJson(data);
       return allowAuthorizationRequestBorderFilterHandler.handle(request);
    }

}
