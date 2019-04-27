package com.beidou.carsocket.web.controller;

import com.beidou.carsocket.web.dao.CarMapper;
import com.beidou.carsocket.web.entity.Car;
import com.beidou.carsocket.web.entity.vo.CarVO;
import com.beidou.carsocket.web.service.CarService;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "CarController|车辆操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @ApiOperation(value = "保存车辆信息", notes = "保存车辆信息")
    @PostMapping(value = "/car")
    public ResponseMsg insert(Car car) {
        Integer flag = carService.insertCar(car);
        if (flag > 0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "获取id对应的车辆信息", notes = "获取id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "/car/{id}")
    public ResponseMsg getById(@PathVariable("id") String carId) {
        Car car = carService.getCar(carId);
        if (car != null) {
            return ResponseMsg.Success("获取成功", car);
        }
        return ResponseMsg.Error("获取失败");
    }


    @ApiOperation(value = "更新id对应的车辆信息", notes = "更新id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @PutMapping(value = "/car/{id}")
    public ResponseMsg updateById(Car car) {
        Integer flag = carService.updateCar(car);
        if (flag > 0) {
            return ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @ApiOperation(value = "删除id对应的车辆信息", notes = "删除id对应的车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value = "/car/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String carId) {
        ResponseMsg responseMsg = null;
        Integer flag = 0;
        if (!StringUtil.isEmpty(carId)) {

            flag = carService.deleteCar(carId);
            if (flag > 0) {
                return ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @ApiOperation(value = "获取车辆信息列表", notes = "获取车辆信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "carNum", value = "车牌号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "carId", value = "车辆编号", required = false, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/cars")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carService.listCar(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }

    @ApiOperation(value = "获取车辆列表", notes = "获取车辆列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", value = "公司编号", required = false, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/getCarList")
    public ResponseMsg getCarList(@RequestParam Map<String, Object> queryMap) {
        List<CarVO> carVOList= carMapper.listCar(queryMap);
        return ResponseMsg.Success("获取成功", carVOList);
    }

}
