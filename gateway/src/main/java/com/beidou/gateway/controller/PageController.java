package com.beidou.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("/login")
    public String loginhtml(){
        return "login";
    }

    @GetMapping("/swagger-ui.html")
    public String swaggeruihtml(){
        return "swagger-ui.html";
    }

    @GetMapping("/druid")
    public String druid(){
        return "druid";
    }
}
