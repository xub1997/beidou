package com.beidou.logger.controller;


import com.beidou.logger.entity.SysLog;
import com.beidou.logger.service.SysLogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "SysLogController|日志管理管理操作")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    @ApiOperation(value="获取id对应的操作日志信息", notes="获取id对应的操作日志信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "操作日志ID", required = true, dataType = "int", paramType="path")
    })
    @GetMapping(value="/syslog/{id}")
    public SysLog getById(@PathVariable("id")Integer id){
        return sysLogService.getById(id);
    }


    @ApiOperation(value="获取操作日志信息列表", notes="获取操作日志信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query")
    })
    @GetMapping(value="/syslogs")
    public PageInfo getAllList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return sysLogService.getAllList(pageNum);
    }


    @ApiOperation(value="获取操作日志信息列表(对应用户)", notes="获取操作日志信息列表（对应用户）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/userSysLogs")
    public PageInfo getMyList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                      @RequestParam(value = "username")String username){
        return sysLogService.getMyList(pageNum,username);
    }


    @ApiOperation(value="查找操作日志", notes="查找操作日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/syslog/searchByUsername")
    public PageInfo searchByUserName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        return sysLogService.searchByUsername(pageNum,username);
    }

}
