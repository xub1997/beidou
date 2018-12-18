package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import org.springframework.web.bind.annotation.GetMapping;


public class PageController {

    @GetMapping("/")
    public String init(){
        return "login.html";
    }

    @GetMapping("/login")
    public String loginhtml(){
        return "login.html";
    }

    @SysLogger("用户管理接口文档")
    @GetMapping("/swagger-ui.html")
    public String swaggeruihtml(){
        return "swagger-ui.html";
    }

    @SysLogger("用户管理数据库监控")
    @GetMapping("/druid")
    public String druid(){
        return "druid";
    }

}
