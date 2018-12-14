package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.User;
import com.beidou.gateway.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @RequiresPermissions("user:create")
    @PostMapping(value = "/user")
    public ResponseMsg insert(User user){
        return userService.insert(user);
    }


    @RequiresPermissions("user:read")
    @GetMapping(value="/user/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return userService.getById(id);
    }


    @RequiresPermissions("user:update")
    @PutMapping(value="/user/{id}")
    public ResponseMsg updateById(User user){
        return userService.updateById(user);
    }


    @RequiresPermissions("user:delete")
    @DeleteMapping(value="/user/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        return userService.deleteById(ids);
    }

    @RequiresPermissions("users:read")
    @GetMapping(value="/users")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return userService.getList(pageNum);
    }

    @RequiresPermissions("userCom:read")
    @GetMapping(value="/user")
    public ResponseMsg getComUserList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId){
        return userService.getComUserList(pageNum,comId);
    }

    @RequiresPermissions("user:searchUser")
    @GetMapping(value="/user/searchByUserName")
    public ResponseMsg searchByUserName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "username")String username ){
        return userService.searchByUserName(pageNum,username);
    }

    @RequiresPermissions("user:searchComUser")
    @GetMapping(value="/user/searchByUserNameAndComId")
    public ResponseMsg searchByUserNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                                @RequestParam(value = "username")String username,
                                                @RequestParam("comId")Integer comId ){
        return userService.searchByUserNameAndComId(pageNum,username,comId);
    }


    @RequiresAuthentication
    @GetMapping(value="/user/judgeUserName")
    public ResponseMsg judgeUserName(@RequestParam(value = "username")String username ){
        return userService.judgeUserName(username);
    }

    @RequiresAuthentication
    @GetMapping(value="/user/modifyPwd")
    public ResponseMsg modifyPwd(@RequestParam(value = "userId")Integer userId ,
                                 @RequestParam(value = "oldPwd")String oldPwd,
                                 @RequestParam(value = "newPwd")String newPwd){
        return userService.modifyPwd(userId,oldPwd,newPwd);
    }


}
