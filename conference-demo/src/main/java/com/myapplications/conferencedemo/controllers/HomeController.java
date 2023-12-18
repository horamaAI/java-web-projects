package com.myapplications.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion;
    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        return new HashMap<String, String>() {{ put("app-version", appVersion);}};
    }
}
