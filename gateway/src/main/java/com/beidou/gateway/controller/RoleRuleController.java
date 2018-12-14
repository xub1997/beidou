package com.beidou.gateway.controller;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.service.RoleRuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class RoleRuleController {

    @Autowired
    private RoleRuleService roleRuleService;

    @RequiresPermissions("roleRule:create")
    @PostMapping(value = "/roleRule")
    public ResponseMsg insert(@RequestParam(value = "roleId")Integer roleId, @RequestParam("ruleIds")String ruleIds){
        return roleRuleService.insert(roleId,ruleIds);
    }

    @RequiresPermissions("roleRule:update")
    @PutMapping(value="/roleRule")
    public ResponseMsg updateByRoleId(@RequestParam("roleId")Integer roleId,@RequestParam("ruleIds")String ruleIds){
        return roleRuleService.updateByRoleId(roleId,ruleIds);
    }
}
