package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Car;
import com.beidou.gateway.service.CarService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "CarController|车辆操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarController {

    @Autowired
    private CarService carService;

    @SysLogger("保存车辆信息")
    @RequiresPermissions("car:create")
    @ApiOperation(value = "保存车辆信息", notes = "保存车辆信息")
    @PostMapping(value = "/car")
    public ResponseMsg insert(Car car) {
        Integer flag = carService.insert(car);
        if (flag > 0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @SysLogger("获取id对应的车辆信息")
    @RequiresPermissions("car:read")
    @ApiOperation(value = "获取id对应的车辆信息", notes = "获取id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/car/{id}")
    public ResponseMsg getById(@PathVariable("id") String carId) {
        Car car = carService.getById(carId);
        if (car != null) {
            return ResponseMsg.Success("获取成功", car);
        }
        return ResponseMsg.Error("获取失败");
    }


    @SysLogger("更新id对应的车辆信息")
    @RequiresPermissions("car:update")
    @ApiOperation(value = "更新id对应的车辆信息", notes = "更新id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/car/{id}")
    public ResponseMsg updateById(Car car) {
        Integer flag = carService.updateById(car);
        if (flag > 0) {
            return ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @SysLogger("删除id对应的车辆信息")
    @RequiresPermissions("car:delete")
    @ApiOperation(value = "删除id对应的车辆信息", notes = "删除id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value = "/car/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String carId) {
        Integer flag = 0;
        if (!StringUtil.isEmpty(carId)) {
            flag = carService.deleteByIds(carId);
            if (flag > 0) {
                return ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @SysLogger("获取车辆信息列表")
    @RequiresPermissions("cars:read")
    @ApiOperation(value = "获取车辆信息列表", notes = "获取车辆信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "carNum", value = "车牌号", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/cars")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carService.getList(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }
}
