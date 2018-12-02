package com.beidou.user.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.user.entity.User;
import com.beidou.user.service.UserService;
import com.beidou.user.utils.ResponseMsg;
import com.beidou.user.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "UserController|用户管理管理操作")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @SysLogger("添加用户信息")
    @ApiOperation(value="添加用户信息", notes="添加用户信息")
    @PostMapping(value = "/user")
    public ResponseMsg insert(User user){
        return userService.insert(user);
    }


    @SysLogger("获取id对应的用户信息")
    @ApiOperation(value="获取id对应的用户信息", notes="获取id对应的用户信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return userService.getById(id);
    }


    @SysLogger("更新id对应的用户信息")
    @ApiOperation(value="更新id对应的用户信息", notes="更新id对应的用户信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @PutMapping(value="/user/{id}")
    public ResponseMsg updateById(User user){
        return userService.updateById(user);
    }


    @SysLogger("删除id对应的用户信息")
    @ApiOperation(value="删除id对应的用户信息", notes="删除id对应的用户信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "用户ID", required = true, dataType = "String", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @DeleteMapping(value="/user/{ids}")
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
                responseMsg=userService.deleteBatch(del_ids);
            }else{
                Integer id = Integer.parseInt(ids);
                responseMsg=userService.deleteById(id);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要删除的用户");
        }
    }


    @SysLogger("获取用户信息列表")
    @ApiOperation(value="获取用户信息列表", notes="获取用户信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/users")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return userService.getList(pageNum);
    }


    @SysLogger("获取用户信息列表(对应公司)")
    @ApiOperation(value="获取用户信息列表(对应公司)", notes="获取用户信息列表（对应公司）")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "Integer", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = true, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user")
    public ResponseMsg getComUserList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId){
        return userService.getComUserList(pageNum,comId);
    }

    @SysLogger("查找用户")
    @ApiOperation(value="查找用户", notes="查找用户")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user/searchByUserName")
    public ResponseMsg searchByUserName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username ){
        return userService.searchByUserName(pageNum,username);
    }

    @SysLogger("查找公司用户")
    @ApiOperation(value="查找公司用户", notes="查找公司用户")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = false, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user/searchByUserNameAndComId")
    public ResponseMsg searchByUserNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "username")String username,@RequestParam("comId")Integer comId ){
        return userService.searchByUserNameAndComId(pageNum,username,comId);
    }

    @SysLogger("判断用户名重复")
    @ApiOperation(value="判断用户名重复", notes="判断用户名重复")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user/judgeUserName")
    public ResponseMsg judgeUserName(@RequestParam(value = "username")String username ){
        return userService.judgeUsername(username);
    }

    @SysLogger("修改密码")
    @ApiOperation(value="修改密码", notes="修改密码")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "oldPwd", value = "旧密码", required = true, dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/user/modifyPwd")
    public ResponseMsg modifyPwd(@RequestParam(value = "userId")Integer userId ,@RequestParam(value = "oldPwd")String oldPwd,@RequestParam(value = "newPwd")String newPwd){
        return userService.modifyPwd(userId,oldPwd,newPwd);
    }

}
