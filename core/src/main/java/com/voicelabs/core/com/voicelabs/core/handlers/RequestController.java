package com.voicelabs.core.com.voicelabs.core.handlers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RequestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}