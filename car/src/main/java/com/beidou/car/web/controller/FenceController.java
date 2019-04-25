package com.beidou.car.web.controller;

import com.beidou.car.web.entity.Fence;
import com.beidou.car.web.service.FenceService;
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

@Api(value = "FenceController|围栏操作")
@RestController
@RequestMapping("/api/v1/carManager")
public class FenceController {
    @Autowired
    private FenceService fenceService;

    @ApiOperation(value = "保存围栏信息", notes = "保存围栏信息")
    @PostMapping(value = "/fence")
    public ResponseMsg insert(Fence fence) {
        Integer flag = fenceService.insertFence(fence);
        if (flag > 0) {
            ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @ApiOperation(value = "获取id对应的围栏信息", notes = "获取id对应的围栏信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "车辆ID", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/fence/{id}")
    public ResponseMsg getById(@PathVariable("id") Integer id) {
        Fence fence = fenceService.getFence(id);
        if (fence != null) {
            ResponseMsg.Success("获取成功", fence);
        }
        return ResponseMsg.Error("获取失败");
    }


    @ApiOperation(value = "更新id对应的围栏信息", notes = "更新id对应的围栏信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "围栏ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/fence/{id}")
    public ResponseMsg updateById(Fence fence) {
        Integer flag = fenceService.updateFence(fence);
        if (flag > 0) {
            ResponseMsg.Success("更新成功");
        }
        return ResponseMsg.Error("更新失败");
    }


    @ApiOperation(value = "删除id对应的围栏信息", notes = "删除id对应的围栏信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "围栏ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value = "/fence/{id}")
    public ResponseMsg deleteByIds(@PathVariable("id") String id) {
        ResponseMsg responseMsg = null;
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {

            Integer typeId = Integer.parseInt(id);
            flag = fenceService.deleteFence(typeId);
            if (flag > 0) {
                ResponseMsg.Success("删除成功");
            }
            return ResponseMsg.Error("删除失败");

        } else {
            return ResponseMsg.Error("请选择要删除的车辆");
        }

    }


    @ApiOperation(value = "获取围栏信息列表", notes = "获取围栏信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "记录条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "typeDesc", value = "类型描述", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/fences")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = fenceService.listFence(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }
}
