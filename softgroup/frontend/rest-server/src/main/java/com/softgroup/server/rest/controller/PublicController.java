package com.softgroup.server.rest.controller;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.server.rest.service.ControllerToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;

/**
 * Created by user on 26.03.2017.
 */

@Controller
@RequestMapping(value = "/api")
public class PublicController {

    @Autowired
    private TypeRouterHandler router;

    @Autowired
    private ControllerToolService restService;

    @RequestMapping(value = "/public",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response publicController(@RequestParam String data) {
       Request<LinkedHashMap> request = restService.parseRequestFromJson(data);
       return router.handle(request);
    }

}
