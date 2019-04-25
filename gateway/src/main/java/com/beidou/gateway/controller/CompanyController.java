package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Company;
import com.beidou.gateway.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "CompanyController|公司管理操作")
@RestController
@RequestMapping("/api/v1/user")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @SysLogger("添加公司信息")
    @RequiresPermissions("company:create")
    @ApiOperation(value="添加公司信息", notes="添加公司信息")
    @PostMapping(value = "/company")
    public ResponseMsg insert(Company company){
        return companyService.insert(company);
    }


    @SysLogger("获取id对应的公司信息")
    @RequiresPermissions("company:read")
    @ApiOperation(value="获取id对应的公司信息", notes="获取id对应的公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司ID", required = true, dataType = "int", paramType="path")
    })
    @GetMapping(value="/company/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return companyService.getById(id);
    }

    @SysLogger("更新id对应的公司信息")
    @RequiresPermissions("company:update")
    @ApiOperation(value="更新id对应的公司信息", notes="更新id对应的公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司ID", required = true, dataType = "int", paramType="path")
    })
    @PutMapping(value="/company/{id}")
    public ResponseMsg updateById(Company company){
        return companyService.updateById(company);
    }


    @SysLogger("删除id对应的公司信息")
    @RequiresPermissions("company:delete")
    @ApiOperation(value="删除id对应的公司信息", notes="删除id对应的公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "公司ID（允许批量，用逗号隔开）", required = true, dataType = "String", paramType="path")
    })
    @DeleteMapping(value="/company/{ids}")
    public ResponseMsg deleteByIds(@PathVariable("ids")String ids){
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
                responseMsg=companyService.deleteBatch(del_ids);
            }else{
                Integer id = Integer.parseInt(ids);
                responseMsg=companyService.deleteById(id);
            }
            return responseMsg;
        }else{
            return ResponseMsg.Error("请选择要删除的公司");
        }

    }

    @SysLogger("获取公司信息")
    @RequiresPermissions("company:readAll")
    @ApiOperation(value="获取公司信息", notes="获取公司信息")
    @GetMapping(value="/company")
    public ResponseMsg getAll(){
        return companyService.getAll();
    }


    @SysLogger("获取公司信息列表")
    @RequiresPermissions("companys:read")
    @ApiOperation(value="获取公司信息列表", notes="获取公司信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query")
    })
    @GetMapping(value="/companys")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return companyService.getList(pageNum);
    }

    @SysLogger("查找公司")
    @RequiresPermissions("company:searchByName")
    @ApiOperation(value="查找公司", notes="查找公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "公司名", required = true, dataType = "String", paramType="query")
    })
    @GetMapping(value="/company/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "name")String name ){
        return companyService.searchByName(pageNum,name);
    }


}
