package com.beidou.car.web.controller;

import com.beidou.car.web.dao.CarMapper;
import com.beidou.car.web.entity.Car;
import com.beidou.car.web.entity.CarPosition;
import com.beidou.car.web.entity.vo.CarPositionVO;
import com.beidou.car.web.service.CarPositionService;
import com.beidou.car.web.service.CarService;
import com.beidou.common.entity.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "CarPositionController|车辆位置操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarPositionController {
    @Autowired
    private CarPositionService carPositionService;

    @Autowired
    private CarMapper carMapper;


    @ApiOperation(value = "保存车辆位置信息", notes = "保存车辆位置信息")
    @PostMapping(value = "/carPosition")
    public ResponseMsg insert(CarPosition carPosition) {
        Integer flag = carPositionService.insertCarPosition(carPosition);
        Car car=new Car();
        car.setCarId(carPosition.getCarId());
        car.setCarStatus(1);
        Integer flag2=carMapper.updateByPrimaryKeySelective(car);
        if (flag > 0&&flag2>0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "车辆下线", notes = "车辆下线")
    @PostMapping(value = "/carLogout")
    public ResponseMsg carLogout(CarPosition carPosition) {
        Car car=new Car();
        car.setCarId(carPosition.getCarId());
        car.setCarStatus(2);
        car.setCarLastPosition(carPosition.getLon()+','+carPosition.getLat());
        car.setLastStopTime(new Date());
        Integer flag=carMapper.updateByPrimaryKeySelective(car);
        if (flag > 0) {
            return ResponseMsg.Success("下线成功");
        }
        return ResponseMsg.Error("下线失败");
    }



    @ApiOperation(value = "获取车辆位置信息", notes = "获取车辆位置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carId", value = "车辆编号", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "beginTime", value = "开始时间", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/carPositions")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        List<CarPositionVO> carPositions= carPositionService.listCarPosition(queryMap);
        return ResponseMsg.Success("获取成功", carPositions);
    }
}
