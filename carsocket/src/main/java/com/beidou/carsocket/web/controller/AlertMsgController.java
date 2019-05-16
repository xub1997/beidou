package com.beidou.carsocket.web.controller;

import com.beidou.carsocket.web.entity.AlertMsg;
import com.beidou.carsocket.web.entity.Fence;
import com.beidou.carsocket.web.service.AlertMsgService;
import com.beidou.common.entity.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "AlertMsgController|报警操作")
@RestController
@RequestMapping("/api/v1/car")
public class AlertMsgController {

    @Autowired
    private AlertMsgService alertMsgService;

    @ApiOperation(value = "保存报警信息", notes = "保存报警信息")
    @PostMapping(value = "/alertMsg")
    public void insert(AlertMsg alertMsg) {
       alertMsgService.insert(alertMsg);
    }


    @ApiOperation(value = "更新报警信息（已读）", notes = "更新报警信息（已读）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "报警信息编号（“,”隔开）", required = true, dataType = "String")
    })
    @PutMapping(value = "/alertMsg")
    public void getById(@RequestParam("ids") String ids) {
        alertMsgService.update(ids);
    }

    @ApiOperation(value = "获取报警信息", notes = "获取报警信息")
    @GetMapping(value = "/alertMsg")
    public List<AlertMsg> getAlertMsg() {
        return alertMsgService.getAlertMsg();
    }
}
