package com.softgroup.server.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/myservice")
public class MainController {

    @RequestMapping(method = RequestMethod.GET,consumes="application/json",produces="application/json")
    @ResponseBody
    public Response getMyDataGet(@RequestParam String data) {
        return "Test with header: "+header +"\r\n</br>And parameters" + param;
    }


}
