package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.CarPosition;
import com.beidou.gateway.service.CarPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "CarPositionController|车辆位置操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarPositionController {

    @Autowired
    private CarPositionService carPositionService;

    @SysLogger("保存车辆位置信息")
    @RequiresPermissions("carPosition:create")
    @ApiOperation(value = "保存车辆位置信息", notes = "保存车辆位置信息")
    @PostMapping(value = "/carPosition")
    public ResponseMsg insert(CarPosition carPosition) {
        Integer flag = carPositionService.insert(carPosition);
        if (flag > 0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }



    @SysLogger("获取车辆位置信息")
    @RequiresPermissions("carPositions:read")
    @ApiOperation(value = "获取车辆位置信息", notes = "获取车辆位置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carId", value = "车辆编号", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "beginTime", value = "开始时间", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/carPositions")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        List<CarPosition> carPositions= carPositionService.getList(queryMap);
        return ResponseMsg.Success("获取成功", carPositions);
    }
}
