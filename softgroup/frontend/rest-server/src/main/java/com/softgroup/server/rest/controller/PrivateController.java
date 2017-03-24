package com.softgroup.server.rest.controller;

import com.softgroup.common.protocol.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class PrivateController {

    @RequestMapping(value = "/private",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response privateController(@RequestParam String data) {
        return new Response();
    }

}