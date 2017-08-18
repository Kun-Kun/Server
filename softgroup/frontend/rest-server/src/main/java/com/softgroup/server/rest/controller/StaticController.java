package com.softgroup.server.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 26.03.2017.
 */

@Controller
@RequestMapping(value = "/")
public class StaticController {

    @RequestMapping(method = RequestMethod.GET)
    public String publicController() {
       return "/index.html";
    }

}
