package com.beidou.carsocket.web.controller;

import com.beidou.carsocket.web.entity.CarPosition;
import com.beidou.carsocket.web.entity.vo.CarPositionVO;
import com.beidou.carsocket.web.service.CarPositionService;
import com.beidou.common.entity.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "保存车辆位置信息", notes = "保存车辆位置信息")
    @PostMapping(value = "/carPosition")
    public ResponseMsg insert(CarPosition carPosition) {
        Integer flag = carPositionService.insertCarPosition(carPosition);
        if (flag > 0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
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
