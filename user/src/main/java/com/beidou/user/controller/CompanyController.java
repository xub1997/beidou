package com.beidou.user.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Company;
import com.beidou.user.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "CompanyController|公司管理操作")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    
    @ApiOperation(value="添加公司信息", notes="添加公司信息")
    @PostMapping(value = "/company")
    public ResponseMsg insert(Company company){
        return companyService.insert(company);
    }



    
    @ApiOperation(value="获取id对应的公司信息", notes="获取id对应的公司信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/company/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return companyService.getById(id);
    }


    
    @ApiOperation(value="更新id对应的公司信息", notes="更新id对应的公司信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司ID", required = true, dataType = "int", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @PutMapping(value="/company/{id}")
    public ResponseMsg updateById(Company company){
        return companyService.updateById(company);
    }



    
    @ApiOperation(value="删除id对应的公司信息", notes="删除id对应的公司信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "公司ID（允许批量，用逗号隔开）", required = true, dataType = "String", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
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


    
    @ApiOperation(value="获取公司信息", notes="获取公司信息")// 使用该注解描述接口方法信息
    @GetMapping(value="/company")
    public ResponseMsg getAll(){
        return companyService.getAll();
    }



    
    @ApiOperation(value="获取公司信息列表", notes="获取公司信息列表")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, dataType = "int", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/companys")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return companyService.getList(pageNum);
    }


    
    @ApiOperation(value="查找公司", notes="查找公司")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码（第一次可以不用传）", required = false, dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "name", value = "公司名", required = true, dataType = "String", paramType="query")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping(value="/company/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return companyService.searchByName(pageNum,name);
    }


}
