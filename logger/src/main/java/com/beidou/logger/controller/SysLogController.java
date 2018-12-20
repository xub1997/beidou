package com.beidou.logger.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.logger.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "LogController|用户管理管理操作")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    //@RequiresPermissions("syslog:read")
    /*@SysLogger("获取id对应的操作日志信息")*/
    @ApiOperation(value="获取id对应的操作日志信息", notes="获取id对应的操作日志信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "操作日志ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/syslog/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return sysLogService.getById(id);
    }

    //@RequiresPermissions("syslogs:read")
    /*@SysLogger("获取操作日志信息列表")*/
    @ApiOperation(value="获取操作日志信息列表", notes="获取操作日志信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/syslogs")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return sysLogService.getAllList(pageNum);
    }

    //@RequiresPermissions("userSysLogs:read")
   /* @SysLogger("获取操作日志信息列表(对应用户)")*/
    @ApiOperation(value="获取操作日志信息列表(对应用户)", notes="获取操作日志信息列表（对应用户）")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/userSysLogs")
    public ResponseMsg getComUserList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                      @RequestParam(value = "username", defaultValue = "1")String username){
        return sysLogService.getMyList(pageNum,username);
    }

    //@RequiresPermissions("syslog:searchByUserName")
    /*@SysLogger("查找操作日志")*/
    @ApiOperation(value="查找操作日志", notes="查找操作日志")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/syslog/searchByUserName")
    public ResponseMsg searchByUserName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        return sysLogService.searchByUsername(pageNum,username);
    }

}
