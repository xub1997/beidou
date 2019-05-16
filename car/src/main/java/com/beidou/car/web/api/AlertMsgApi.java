package com.beidou.car.web.api;

import com.beidou.car.web.entity.AlertMsg;
import com.beidou.car.web.service.AlertMsgService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertMsgApi {

    @Autowired
    private AlertMsgService alertMsgService;

    @ApiOperation(value = "保存报警信息", notes = "保存报警信息")
    @PostMapping(value = "/alertMsg")
    public void insert(@RequestBody AlertMsg alertMsg) {
        alertMsgService.insert(alertMsg);
    }


    @ApiOperation(value = "更新报警信息（已读）", notes = "更新报警信息（已读）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "报警信息编号（“,”隔开）", required = true, dataType = "String")
    })
    @PutMapping(value = "/alertMsg")
    public void update(@RequestParam("ids") String ids) {
        alertMsgService.update(ids);
    }

    @ApiOperation(value = "获取报警信息", notes = "获取报警信息")
    @GetMapping(value = "/alertMsg")
    public List<AlertMsg> getAlertMsg() {
        return alertMsgService.getAlertMsg();
    }
}
