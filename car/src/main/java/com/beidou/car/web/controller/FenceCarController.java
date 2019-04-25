package com.beidou.car.web.controller;

import com.beidou.car.web.entity.FenceCar;
import com.beidou.car.web.service.FenceCarService;
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

@Api(value = "FenceCarController|围栏车辆操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class FenceCarController {
    @Autowired
    private FenceCarService fenceCarService;

    @ApiOperation(value = "保存围栏车辆信息", notes = "保存围栏车辆信息")
    @PostMapping(value = "/fenceCar")
    public ResponseMsg insert(FenceCar fenceCar) {
        Integer flag = fenceCarService.insertFenceCar(fenceCar);
        if (flag > 0) {
            ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "获取id对应的围栏车辆信息", notes = "获取id对应的围栏车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/fenceCar/{id}")
    public ResponseMsg getById(@PathVariable("id") Integer id) {
        FenceCar fenceCar = fenceCarService.getFenceCar(id);
        if (fenceCar != null) {
            ResponseMsg.Success("获取成功", fenceCar);
        }
        return ResponseMsg.Error("获取失败");
    }


    @ApiOperation(value = "更新id对应的围栏车辆信息", notes = "更新id对应的围栏车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "围栏车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/fenceCar/{id}")
    public ResponseMsg updateById(FenceCar fenceCar) {
        Integer flag = fenceCarService.updateFenceCar(fenceCar);
        if (flag > 0) {
            ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @ApiOperation(value = "删除id对应的围栏车辆信息", notes = "删除id对应的围栏车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "围栏车辆车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value = "/fenceCar/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String id) {
        ResponseMsg responseMsg = null;
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {
            Integer typeId = Integer.parseInt(id);
            flag = fenceCarService.deleteFenceCar(typeId);
            if (flag > 0) {
                ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @ApiOperation(value = "获取围栏车辆信息列表", notes = "获取围栏车辆信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fenceId", value = "围栏编号", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/fenceCars")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = fenceCarService.listFenceCar(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }

}
