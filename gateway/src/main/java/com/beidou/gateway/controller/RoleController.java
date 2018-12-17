package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Role;
import com.beidou.gateway.service.RoleService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "RoleController|角色管理操作")
@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @SysLogger("添加角色信息")
    @RequiresPermissions("role:create")
    @PostMapping(value = "/role")
    public ResponseMsg insert(Role role){
        return roleService.insert(role);
    }

    @SysLogger("获取id对应的角色信息")
    @RequiresPermissions("role:read")
    @GetMapping(value="/role/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return roleService.getById(id);
    }


    @SysLogger("更新id对应的角色信息")
    @RequiresPermissions("role:update")
    @PutMapping(value="/role/{id}")
    public ResponseMsg updateById(Role role){
        return roleService.updateById(role);
    }


    @SysLogger("删除id对应的角色信息")
    @RequiresPermissions("role:delete")
    @DeleteMapping(value="/role/{ids}")
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
                responseMsg=roleService.deleteBatch(del_ids);
            }else{
                Integer id = Integer.parseInt(ids);
                responseMsg=roleService.deleteById(id);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要删除的角色");
        }
    }


    @SysLogger("获取角色信息列表")
    @RequiresPermissions("roles:read")
    @GetMapping(value="/roles")
    public ResponseMsg getAll(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return roleService.getList(pageNum);
    }

    @SysLogger("查找角色")
    @RequiresPermissions("role:searchByName:read")
    @GetMapping(value="/role/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return roleService.searchByName(pageNum,name);
    }

}
