package com.beidou.user.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Dept;
import com.beidou.user.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "DeptController|部门管理操作")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    
    @ApiOperation(value="添加部门信息", notes="添加部门信息")
    @PostMapping(value = "/dept")
    public ResponseMsg insert(Dept dept){
        return deptService.insert(dept);
    }



    
    @ApiOperation(value="获取id对应的部门信息", notes="获取id对应的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门ID", required = true, dataType = "int", paramType="path")
    })
    @GetMapping(value="/dept/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return deptService.getById(id);
    }


    
    @ApiOperation(value="更新id对应的部门信息", notes="更新id对应的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门ID", required = true, dataType = "int", paramType="path")
    })
    @PutMapping(value="/dept/{id}")
    public ResponseMsg updateById(Dept dept){
        return deptService.updateById(dept);
    }


    
    @ApiOperation(value="删除id对应的部门信息", notes="删除id对应的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "部门ID", required = true, dataType = "String", paramType="path")
    })
    @DeleteMapping(value="/dept/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        ResponseMsg responseMsg;
        if(!StringUtil.isEmpty(ids)){
            //批量删除
            if(ids.contains(",")){
                List<Integer> del_ids = new ArrayList();
                String[] str_ids = ids.split(",",-1);
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


    
    @ApiOperation(value="获取公司部门", notes="获取公司部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", value = "公司id", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/comDept")
    public ResponseMsg getComDept(@RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDept(comId);
    }


    
    @ApiOperation(value="获取部门信息", notes="获取部门信息")
    @GetMapping(value="/dept")
    public ResponseMsg getAll(){
        return deptService.getAll();
    }


    
    @ApiOperation(value="获取部门信息列表", notes="获取部门信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/depts")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return deptService.getList(pageNum);
    }


    
    @ApiOperation(value="获取部门列表（对应公司）", notes="获取部门列表（对应公司）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/comDepts")
    public ResponseMsg getComDeptList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDeptList(pageNum,comId);
    }


    
    @ApiOperation(value="查找部门", notes="查找部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "部门名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/dept/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return deptService.searchByName(pageNum,name);
    }


    
    @ApiOperation(value="查找公司部门", notes="查找公司部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "部门名", required = true, dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "comId", value = "公司id", required = false, dataType = "int", paramType="query")
    })
    @GetMapping(value="/dept/searchByNameAndComId")
    public ResponseMsg searchByNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name,@RequestParam("comId")Integer comId ){
        return deptService.searchByNameAndComId(pageNum,name,comId);
    }

}
