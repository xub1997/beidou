package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.vo.ComVO;
import com.beidou.gateway.entity.vo.UserVO;
import com.beidou.gateway.service.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "DriverController|车辆公司操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @SysLogger("获取全部公司列表")
    @RequiresPermissions("car:readComs")
    @ApiOperation(value = "获取全部公司列表", notes = "获取全部公司列表")
    @GetMapping(value = "/com")
    public ResponseMsg getAllCom() {
        List<ComVO> coms = driverService.getAllCom();
        return ResponseMsg.Success("获取成功", coms);
    }

    @SysLogger("获取公司用户列表")
    @RequiresPermissions("car:readComUsers")
    @ApiOperation(value = "获取公司用户列表", notes = "获取公司用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", value = "公司编号", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/comUser")
    public ResponseMsg getAllComUser(@RequestParam("comId")Integer comId) {
        List<UserVO> userVOS = driverService.getAllComUser(comId);
        return ResponseMsg.Success("获取成功", userVOS);
    }
}
