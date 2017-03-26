package com.softgroup.server.rest.controller;

import com.softgroup.common.protocol.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 26.03.2017.
 */

@Controller
@RequestMapping(value = "/api")
public class PublicController {

    @RequestMapping(value = "/public",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response publicController(@RequestParam String data) {
        return new Response();
    }

}
