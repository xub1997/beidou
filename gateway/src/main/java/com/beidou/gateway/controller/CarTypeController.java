package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.CarType;
import com.beidou.gateway.service.CarTypeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "CarTypeTypeController|车辆类型操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarTypeController {
    @Autowired
    private CarTypeService carTypeService;

    @SysLogger("保存车辆类型信息")
    @RequiresPermissions("carType:create")
    @ApiOperation(value = "保存车辆类型信息", notes = "保存车辆类型信息")
    @PostMapping(value = "/carType")
    public ResponseMsg insert(CarType carType) {
        Integer flag = carTypeService.insert(carType);
        if (flag > 0) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @SysLogger("获取id对应的车辆类型信息")
    @RequiresPermissions("carType:read")
    @ApiOperation(value = "获取id对应的车辆类型信息", notes = "获取id对应的车辆类型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/carType/{id}")
    public ResponseMsg getById(@PathVariable("id") String id) {
        CarType carType = carTypeService.getById(id);
        if (carType != null) {
            return ResponseMsg.Success("获取成功", carType);
        }
        return ResponseMsg.Error("获取失败");
    }


    @SysLogger("更新id对应的车辆类型信息")
    @RequiresPermissions("carType:update")
    @ApiOperation(value = "更新id对应的车辆类型信息", notes = "更新id对应的车辆类型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆类型ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/carType/{id}")
    public ResponseMsg updateById(CarType carType) {
        Integer flag = carTypeService.updateById(carType);
        if (flag > 0) {
            return ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @SysLogger("删除id对应的车辆类型信息")
    @RequiresPermissions("carType:delete")
    @ApiOperation(value = "删除id对应的车辆类型信息", notes = "删除id对应的车辆类型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value = "/carType/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String typeId) {
        Integer flag = 0;
        if (!StringUtil.isEmpty(typeId)) {

            flag = carTypeService.deleteByIds(typeId);
            if (flag > 0) {
                return ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @SysLogger("获取车辆类型信息列表")
    @RequiresPermissions("carTypes:read")
    @ApiOperation(value = "获取车辆类型信息列表", notes = "获取车辆类型信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "typeDesc", value = "类型描述", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/carTypes")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carTypeService.getList(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }

    @SysLogger("获取全部车辆类型信息列表")
    @RequiresPermissions("carTypesAll:read")
    @ApiOperation(value = "获取全部车辆类型信息列表", notes = "获取全部车辆类型信息列表")
    @GetMapping(value = "/carTypesAll")
    public ResponseMsg getAll() {
        List<CarType> carTypes = carTypeService.getAll();
        return ResponseMsg.Success("获取成功", carTypes);
    }

}
