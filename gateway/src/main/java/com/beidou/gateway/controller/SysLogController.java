package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.entity.SysLog;
import com.beidou.gateway.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/logger")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @SysLogger("读取对应日志信息")
    @RequiresPermissions("syslog:read")
    @GetMapping(value="/syslog/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        SysLog sysLog=sysLogService.getById(id);
        if(sysLog==null){
            ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",sysLog);
    }


    @SysLogger("获取所有日志")
    @RequiresPermissions("syslogs:read")
    @GetMapping(value="/syslogs")
    public ResponseMsg getAllList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        PageInfo pageInfo=sysLogService.getAllList(pageNum);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }

    @SysLogger("获取本人操作日志")
    @RequiresPermissions("userSysLogs:read")
    @GetMapping(value="/userSysLogs")
    public ResponseMsg getMyList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                   @RequestParam(value = "username")String username){
        PageInfo pageInfo=sysLogService.getMyList(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }


    @SysLogger("查找用户操作日志")
    @RequiresPermissions("syslog:searchByUsername:read")
    @GetMapping(value="/syslog/searchByUsername")
    public ResponseMsg searchByUsername(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        PageInfo pageInfo=sysLogService.searchByUsername(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }
}
