package com.beidou.gateway.service;

import com.beidou.gateway.entity.AlertMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(value = "car")
public interface AlertMsgService {

    @PostMapping(value = "/alertMsg")
    public void insert(@RequestBody AlertMsg alertMsg);



    @PutMapping(value = "/alertMsg")
    public void update(@RequestParam("ids") String ids);


    @GetMapping(value = "/alertMsg")
    public List<AlertMsg> getAlertMsg();
}
