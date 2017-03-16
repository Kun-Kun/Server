package com.softgroup.server.rest.controller;

import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.protocol.Response;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
@Import(DataMapperAppCfg.class)
public class MainController {

    @RequestMapping(value = "/private",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response privateController(@RequestParam String data) {
        return new Response();
    }

    @RequestMapping(value = "/public",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response publicController(@RequestParam String data) {
        return new Response();
    }

}
