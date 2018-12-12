package com.beidou.user.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.user.entity.Dept;
import com.beidou.user.service.DeptService;
import com.beidou.user.utils.ResponseMsg;
import com.beidou.user.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "DeptController|部门管理操作")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequiresPermissions("dept:create")
    @SysLogger("添加部门信息")
    @ApiOperation(value="添加部门信息", notes="添加部门信息")
    @PostMapping(value = "/dept")
    public ResponseMsg insert(Dept dept){
        return deptService.insert(dept);
    }


    @RequiresPermissions("dept:read")
    @SysLogger("获取id对应的部门信息")
    @ApiOperation(value="获取id对应的部门信息", notes="获取id对应的部门信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/dept/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return deptService.getById(id);
    }

    @RequiresPermissions("dept:update")
    @SysLogger("更新id对应的部门信息")
    @ApiOperation(value="更新id对应的部门信息", notes="更新id对应的部门信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @PutMapping(value="/dept/{id}")
    public ResponseMsg updateById(Dept dept){
        return deptService.updateById(dept);
    }

    @RequiresPermissions("dept:delete")
    @SysLogger("删除id对应的部门信息")
    @ApiOperation(value="删除id对应的部门信息", notes="删除id对应的部门信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "部门ID", required = true, dataType = "String", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @DeleteMapping(value="/dept/{ids}")
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
                responseMsg=deptService.deleteBatch(del_ids);
            }else{
                Integer id = Integer.parseInt(ids);
                responseMsg=deptService.deleteById(id);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要删除的公司");
        }

    }

    @RequiresPermissions("comDept:read")
    @SysLogger("获取公司部门")
    @ApiOperation(value="获取公司部门", notes="获取公司部门")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", value = "公司id", required = true, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/comDept")
    public ResponseMsg getComDept(@RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDept(comId);
    }

    @RequiresPermissions("dept:readAll")
    @SysLogger("获取部门信息")
    @ApiOperation(value="获取部门信息", notes="获取部门信息")// 使用该注解描述接口方法信息
    @GetMapping(value="/dept")
    public ResponseMsg getAll(){
        return deptService.getAll();
    }

    @RequiresPermissions("depts:read")
    @SysLogger("获取部门信息列表")
    @ApiOperation(value="获取部门信息列表", notes="获取部门信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/depts")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return deptService.getList(pageNum);
    }

    @RequiresPermissions("comDepts:read")
    @SysLogger("获取部门列表（对应公司）")
    @ApiOperation(value="获取部门列表（对应公司）", notes="获取部门列表（对应公司）")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = true, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/comDepts")
    public ResponseMsg getComDeptList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDeptList(pageNum,comId);
    }

    @RequiresPermissions("dept:searchByName:read")
    @SysLogger("查找部门")
    @ApiOperation(value="查找部门", notes="查找部门")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "部门名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/dept/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return deptService.searchByName(pageNum,name);
    }

    @RequiresPermissions("dept:searchByNameAndComId:read")
    @SysLogger("查找公司部门")
    @ApiOperation(value="查找公司部门", notes="查找公司部门")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "部门名", required = true, dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = false, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/dept/searchByNameAndComId")
    public ResponseMsg searchByNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name,@RequestParam("comId")Integer comId ){
        return deptService.searchByNameAndComId(pageNum,name,comId);
    }

}
