package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.UserRole;
import com.beidou.gateway.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "UserRoleController|用户角色管理管理操作")
@RestController
@RequestMapping("/api/v1/user")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @SysLogger("添加用户-角色管理信息")
    @RequiresPermissions("userRole:create")
    @ApiOperation(value="添加用户-角色管理信息", notes="添加用户-角色管理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "roleIds", value = "角色ID（用逗号隔开）", required = true, dataType = "String", paramType="query")
    })
    @PostMapping(value = "/userRole")
    public ResponseMsg insert(@RequestParam(value = "userId")Integer userId,
                              @RequestParam("roleIds")String roleIds){
        ResponseMsg responseMsg;
        if(!StringUtil.isEmpty(roleIds)){
            //批量删除
            if(roleIds.contains(",")){
                List<Integer> add_ids = new ArrayList();
                String[] str_ids = roleIds.split(",");

                //组装id的集合
                for (String string : str_ids) {
                    add_ids.add(Integer.parseInt(string));
                }
                responseMsg=userRoleService.batchInsert(userId,add_ids);
            }else{
                Integer id = Integer.parseInt(roleIds);
                UserRole userRole=new UserRole(userId,id);
                responseMsg=userRoleService.insert(userRole);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要添加的权限");
        }
    }

    @SysLogger("更新id对应的用户-角色管理信息")
    @RequiresPermissions("userRole:update")
    @ApiOperation(value="更新id对应的用户-角色管理信息", notes="更新id对应的用户-角色管理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "roleIds", value = "角色ID（用逗号隔开）", required = true, dataType = "String", paramType="query")
    })
    @PutMapping(value="/userRole")
    public ResponseMsg updateByUserId(@RequestParam(value = "userId")Integer userId,
                                      @RequestParam("roleIds")String roleIds){
        ResponseMsg responseMsg;
        if(!StringUtil.isEmpty(roleIds)){
            //批量删除
            if(roleIds.contains(",")){
                List<Integer> add_ids = new ArrayList();
                String[] str_ids = roleIds.split(",");
                //组装id的集合
                for (String string : str_ids) {
                    add_ids.add(Integer.parseInt(string));
                }
                responseMsg=userRoleService.updateByUserIdBatch(userId,add_ids);
            }else{
                Integer id = Integer.parseInt(roleIds);
                UserRole userRole=new UserRole(userId,id);
                responseMsg=userRoleService.updateByUserId(userRole);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要添加的权限");
        }
    }


}
