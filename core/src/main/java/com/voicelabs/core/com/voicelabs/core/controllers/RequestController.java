package com.voicelabs.core.com.voicelabs.core.controllers;

import com.voicelabs.core.services.ParseLog4jFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

    @Autowired
    private ParseLog4jFileService parseLog4jFileService;

    @RequestMapping(value="/parseNow",method = RequestMethod.GET)
    @ResponseBody
    public String index() {

        return parseLog4jFileService.parseFiles();
        //return "index";
    }
}