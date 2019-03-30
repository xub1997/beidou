package com.beidou.car.web.controller;

import com.beidou.car.web.entity.Car;
import com.beidou.car.web.service.CarService;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "CarController|车辆操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation(value = "保存车辆信息", notes = "保存车辆信息")
    @PostMapping(value = "/car")
    public ResponseMsg insert(Car car) {
        Integer flag = carService.insertCar(car);
        if (flag > 0) {
            ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "获取id对应的车辆信息", notes = "获取id对应的车辆信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value = "/car/{id}")
    public ResponseMsg getById(@PathVariable("id") Integer id) {
        Car car = carService.getCar(id);
        if (car != null) {
            ResponseMsg.Success("获取成功", car);
        }
        return ResponseMsg.Error("获取失败");
    }


    @ApiOperation(value = "更新id对应的车辆信息", notes = "更新id对应的车辆信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @PutMapping(value = "/car/{id}")
    public ResponseMsg updateById(Car car) {
        Integer flag = carService.updateCar(car);
        if (flag > 0) {
            ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @ApiOperation(value = "删除id对应的车辆信息", notes = "删除id对应的车辆信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @DeleteMapping(value = "/car/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String id) {
        ResponseMsg responseMsg = null;
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {

            Integer carid = Integer.parseInt(id);
            flag = carService.deleteCar(carid);
            if (flag > 0) {
                ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @ApiOperation(value = "获取车辆信息列表", notes = "获取车辆信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "carNum", value = "车牌号", required = false, dataType = "int", paramType = "query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value = "/cars")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carService.listCar(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }
}
