package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin/log")
public class SysLogController {

    @RequestMapping
    public String showform(){return "syslog";}
}
