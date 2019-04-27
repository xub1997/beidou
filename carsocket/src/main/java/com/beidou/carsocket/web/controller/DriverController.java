package com.beidou.carsocket.web.controller;

import com.beidou.carsocket.web.entity.vo.ComVO;
import com.beidou.carsocket.web.entity.vo.UserVO;
import com.beidou.carsocket.web.service.DriverService;
import com.beidou.common.entity.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取全部公司列表", notes = "获取全部公司列表")
    @GetMapping(value = "/com")
    public ResponseMsg getAllCom() {
        List<ComVO> coms = driverService.getComs();
        return ResponseMsg.Success("获取成功", coms);
    }

    @ApiOperation(value = "获取公司用户列表", notes = "获取公司用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", value = "公司编号", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/comUser")
    public ResponseMsg getAllComUser(@RequestParam("comId")Integer comId) {
        List<UserVO> userVOS = driverService.getComUser(comId);
        return ResponseMsg.Success("获取成功", userVOS);
    }
}
