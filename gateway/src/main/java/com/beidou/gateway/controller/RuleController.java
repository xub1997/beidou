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

@Api(value = "RuleController|权限管理操作")
@RestController
@RequestMapping("/api/v1")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @SysLogger("添加权限信息")
    @RequiresPermissions("rule:create")
    @PostMapping(value = "/rule")
    public ResponseMsg insert(Rule rule){
        return ruleService.insert(rule);
    }



    @SysLogger("获取id对应的权限信息")
    @RequiresPermissions("rule:read")
    @GetMapping(value="/rule/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return ruleService.getById(id);
    }


    @SysLogger("更新id对应的权限信息")
    @RequiresPermissions("rule:update")
    @PutMapping(value="/rule/{id}")
    public ResponseMsg updateById(Rule rule){
        return ruleService.updateById(rule);
    }


    @SysLogger("删除id对应的权限信息")
    @RequiresPermissions("rule:delete")
    @DeleteMapping(value="/rule/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        ResponseMsg responseMsg;
        if(!StringUtil.isEmpty(ids)){
            //批量删除
            if(ids.contains(",")){
                List<Integer> del_ids = new ArrayList();
                String[] str_ids = ids.split(",");
                //组装id的集合
                for (String string : str_ids) {
                    del_ids.add(Integer.parseInt(string));
                }
                responseMsg=ruleService.deleteBatch(del_ids);
            }else{
                Integer id = Integer.parseInt(ids);
                responseMsg=ruleService.deleteById(id);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要删除的权限");
        }
    }



    @SysLogger("获取权限信息列表")
    @RequiresPermissions("rules:read")
    @GetMapping(value="/rules")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return ruleService.getList(pageNum);
    }

    @SysLogger("获取角色对应权限")
    @RequiresPermissions("roleRule:read")
    @GetMapping(value="/roleRule")
    public ResponseMsg getRoleRule(@RequestParam("roleId")Integer roleId ){
        return ruleService.getRoleRule(roleId);
    }


    @SysLogger("查找权限")
    @RequiresPermissions("rule:search")
    @GetMapping(value="/rule/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return ruleService.searchByName(pageNum,name);
    }

}
