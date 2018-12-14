package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Service
@FeignClient(value = "user")
public interface RoleRuleService {

    @PostMapping(value = "/roleRule")
    public ResponseMsg insert(@RequestParam(value = "roleId")Integer roleId, @RequestParam("ruleIds")String ruleIds);


    @PutMapping(value="/roleRule")
    public ResponseMsg updateByRoleId(@RequestParam("roleId")Integer roleId,@RequestParam("ruleIds")String ruleIds);
}
