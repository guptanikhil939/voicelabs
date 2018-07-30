package com.voicelabs.core.com.voicelabs.core.controllers;

import com.voicelabs.core.services.ParseLog4jFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RequestController {

    @Autowired
    private ParseLog4jFileService parseLog4jFileService;

    @RequestMapping("/")
    public String index() {

        return parseLog4jFileService.parseFiles();
    }
}