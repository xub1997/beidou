package com.beidou.gateway.test;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.SysLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/logger")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping(value="/syslog/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        SysLog sysLog=sysLogService.getById(id);
        if(sysLog==null){
            ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",sysLog);
    }


    @GetMapping(value="/syslogs")
    public ResponseMsg getAllList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        PageInfo pageInfo=sysLogService.getAllList(pageNum);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }


    @GetMapping(value="/userSysLogs")
    public ResponseMsg getMyList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                   @RequestParam(value = "username")String username){
        PageInfo pageInfo=sysLogService.getMyList(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }


    @GetMapping(value="/syslog/searchByUsername")
    public ResponseMsg searchByUsername(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        PageInfo pageInfo=sysLogService.searchByUsername(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }
}
