package com.beidou.gateway.controller;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.Role;
import com.beidou.gateway.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequiresPermissions("role:create")
    @PostMapping(value = "/role")
    public ResponseMsg insert(Role role){
        return roleService.insert(role);
    }

    @RequiresPermissions("role:read")
    @GetMapping(value="/role/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return roleService.getById(id);
    }


    @RequiresPermissions("role:update")
    @PutMapping(value="/role/{id}")
    public ResponseMsg updateById(Role role){
        return roleService.updateById(role);
    }


    @RequiresPermissions("role:delete")
    @DeleteMapping(value="/role/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        return roleService.deleteById(ids);
    }

    @RequiresPermissions("roles:read")
    @GetMapping(value="/roles")
    public ResponseMsg getAll(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return roleService.getAll(pageNum);
    }

    @RequiresPermissions("role:searchByName:read")
    @GetMapping(value="/role/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return roleService.searchByName(pageNum,name);
    }

}
