package com.beidou.gateway.test;

import com.beidou.gateway.entity.SysLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/logger")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping(value="/syslog/{id}")
    public SysLog getById(@PathVariable("id")Integer id){
        return sysLogService.getById(id);
    }


    @GetMapping(value="/syslogs")
    public PageInfo getAllList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return sysLogService.getAllList(pageNum);
    }


    @GetMapping(value="/userSysLogs")
    public PageInfo getMyList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                   @RequestParam(value = "username")String username){
        return sysLogService.getMyList(pageNum,username);
    }


    @GetMapping(value="/syslog/searchByUsername")
    public PageInfo searchByUsername(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        return sysLogService.searchByUsername(pageNum,username);
    }
}
