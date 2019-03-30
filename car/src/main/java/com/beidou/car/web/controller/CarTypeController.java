package com.beidou.car.web.controller;

import com.beidou.car.web.entity.CarType;
import com.beidou.car.web.service.CarTypeService;
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

@Api(value = "CarTypeTypeController|车辆类型操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class CarTypeController {
    @Autowired
    private CarTypeService carTypeService;

    @ApiOperation(value = "保存车辆类型信息", notes = "保存车辆类型信息")
    @PostMapping(value = "/carType")
    public ResponseMsg insert(CarType carType) {
        Integer flag = carTypeService.insertCarType(carType);
        if (flag > 0) {
            ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "获取id对应的车辆类型信息", notes = "获取id对应的车辆类型信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value = "/carType/{id}")
    public ResponseMsg getById(@PathVariable("id") Integer id) {
        CarType carType = carTypeService.getCarType(id);
        if (carType != null) {
            ResponseMsg.Success("获取成功", carType);
        }
        return ResponseMsg.Error("获取失败");
    }


    @ApiOperation(value = "更新id对应的车辆类型信息", notes = "更新id对应的车辆类型信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆类型ID", required = true, dataType = "int", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @PutMapping(value = "/carType/{id}")
    public ResponseMsg updateById(CarType carType) {
        Integer flag = carTypeService.updateCarType(carType);
        if (flag > 0) {
            ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @ApiOperation(value = "删除id对应的车辆类型信息", notes = "删除id对应的车辆类型信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "String", paramType = "path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @DeleteMapping(value = "/carType/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String id) {
        ResponseMsg responseMsg = null;
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {

            Integer typeId = Integer.parseInt(id);
            flag = carTypeService.deleteCarType(typeId);
            if (flag > 0) {
                ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @ApiOperation(value = "获取车辆类型信息列表", notes = "获取车辆类型信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "typeDesc", value = "类型描述", required = false, dataType = "int", paramType = "query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value = "/carTypes")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carTypeService.listCarType(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }
}
