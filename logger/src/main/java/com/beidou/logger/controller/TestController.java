package com.beidou.logger.controller;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.logger.entity.SysLog;
import com.beidou.logger.service.SysLogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "TestController|日志管理管理操作")
@RestController
@RequestMapping("/api/v1/logger")
public class TestController {

    @Autowired
    private SysLogService sysLogService;

    @ApiOperation(value="获取id对应的操作日志信息", notes="获取id对应的操作日志信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "操作日志ID", required = true, dataType = "int", paramType="path")
    })
    @GetMapping(value="/syslog/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        SysLog sysLog=sysLogService.getById(id);
        if(sysLog==null){
            ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",sysLog);
    }


    @ApiOperation(value="获取操作日志信息列表", notes="获取操作日志信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query")
    })
    @GetMapping(value="/syslogs")
    public ResponseMsg getAllList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        PageInfo pageInfo=sysLogService.getAllList(pageNum);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }


    @ApiOperation(value="获取操作日志信息列表(对应用户)", notes="获取操作日志信息列表（对应用户）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/userSysLogs")
    public ResponseMsg getMyList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                 @RequestParam(value = "username")String username){
        PageInfo pageInfo=sysLogService.getMyList(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }


    @ApiOperation(value="查找操作日志", notes="查找操作日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/syslog/searchByUsername")
    public ResponseMsg searchByUsername(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        PageInfo pageInfo=sysLogService.searchByUsername(pageNum,username);
        if(pageInfo.getList().size()==0){
            return ResponseMsg.Error("数据为空");
        }
        return ResponseMsg.Success("查询成功",pageInfo);
    }
}
