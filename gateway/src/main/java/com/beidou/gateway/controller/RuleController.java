package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Rule;
import com.beidou.gateway.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequiresPermissions("rule:create")
    @PostMapping(value = "/rule")
    public ResponseMsg insert(Rule rule){
        return ruleService.insert(rule);
    }



    @RequiresPermissions("rule:read")
    @GetMapping(value="/rule/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return ruleService.getById(id);
    }


    @RequiresPermissions("rule:update")
    @PutMapping(value="/rule/{id}")
    public ResponseMsg updateById(Rule rule){
        return ruleService.updateById(rule);
    }


    @RequiresPermissions("rule:delete")
    @DeleteMapping(value="/rule/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        return ruleService.deleteById(ids);
    }


    @RequiresPermissions("rules:read")
    @GetMapping(value="/rules")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return ruleService.getList(pageNum);
    }

    @RequiresPermissions("roleRule:read")
    @GetMapping(value="/roleRule")
    public ResponseMsg getRoleRule(@RequestParam("roleId")Integer roleId ){
        return ruleService.getRoleRule(roleId);
    }


    @RequiresPermissions("rule:search")
    @GetMapping(value="/rule/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return ruleService.searchByName(pageNum,name);
    }

}
