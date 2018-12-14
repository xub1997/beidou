package com.beidou.gateway.controller;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequiresPermissions("userRole:create")
    @PostMapping(value = "/userRole")
    public ResponseMsg insert(@RequestParam(value = "userId")Integer userId,
                              @RequestParam("roleIds")String roleIds){
        return userRoleService.insert(userId,roleIds);
    }

    @RequiresPermissions("userRole:update")
    @PutMapping(value="/userRole")
    public ResponseMsg updateByUserId(@RequestParam(value = "userId")Integer userId,
                                      @RequestParam("roleIds")String roleIds){
        return userRoleService.updateByUserId(userId,roleIds);
    }


}
