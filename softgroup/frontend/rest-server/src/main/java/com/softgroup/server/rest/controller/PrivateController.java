package com.softgroup.server.rest.controller;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.server.rest.service.RestToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@Controller
@RequestMapping(value = "/api")
public class PrivateController {

    @Autowired
    private TypeRouterHandler router;

    @Autowired
    private RestToolService restService;

    @RequestMapping(value = "/private",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response privateController(@RequestParam String data) {
        Request<LinkedHashMap> request = restService.parseRequestFromJson(data);
        request = restService.setRoutingData(request);
        return router.handle(request);
    }

}
