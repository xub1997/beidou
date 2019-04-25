package com.beidou.user.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Role;
import com.beidou.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "RoleController|角色管理操作")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    
    @ApiOperation(value="添加角色信息", notes="添加角色信息",produces ="application/json")
    @PostMapping(value = "/role")
    public ResponseMsg insert(Role role){
        return roleService.insert(role);
    }


    
    @ApiOperation(value="获取id对应的角色信息", notes="获取id对应的角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "int", paramType="path")
    })
    @GetMapping(value="/role/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return roleService.getById(id);
    }


    
    @ApiOperation(value="更新id对应的角色信息", notes="更新id对应的角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "int", paramType="path")
    })
    @PutMapping(value="/role/{id}")
    public ResponseMsg updateById(Role role){
        return roleService.updateById(role);
    }


    
    @ApiOperation(value="删除id对应的角色信息", notes="删除id对应的角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "角色ID", required = true, dataType = "String", paramType="path")
    })
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


    
    @ApiOperation(value="获取角色信息列表", notes="获取角色信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/roles")
    public ResponseMsg getAll(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return roleService.getList(pageNum);
    }

    
    @ApiOperation(value="查找角色", notes="查找角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "角色名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/role/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return roleService.searchByName(pageNum,name);
    }

    @ApiOperation(value="获取用户对应角色", notes="获取用户对应角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/userRole")
    public ResponseMsg getUserRole(@RequestParam("userId")Integer userId ){
        return roleService.getUserRole(userId);
    }


    @ApiOperation(value="获取所有角色", notes="获取所有角色")
    @GetMapping(value="/role/getAll")
    public ResponseMsg getAll(){
        return roleService.getAll();
    }

}
