package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {


    @GetMapping("/login")
    public String loginhtml(){
        return "login";
    }

    @SysLogger("用户管理接口文档")
    @GetMapping("/swagger-ui")
    public String swaggeruihtml(){
        return "swagger-ui";
    }

    @SysLogger("用户管理数据库监控")
    @GetMapping("/druid")
    public String druid(){
        return "druid";
    }

}
