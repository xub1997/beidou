package com.beidou.gateway.controller;


import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Company;
import com.beidou.gateway.service.CompanyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequiresPermissions("company:create")
    @PostMapping(value = "/company")
    public ResponseMsg insert(Company company){
        return companyService.insert(company);
    }


    @RequiresPermissions("company:read")
    @GetMapping(value="/company/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return companyService.getById(id);
    }

    @RequiresPermissions("company:update")
    @PutMapping(value="/company/{id}")
    public ResponseMsg updateById(Company company){
        return companyService.updateById(company);
    }


    @RequiresPermissions("company:delete")
    @DeleteMapping(value="/company/{ids}")
    public ResponseMsg deleteByIds(@PathVariable("ids")String ids){
        return companyService.deleteByIds(ids);
    }

    @RequiresPermissions("company:readAll")
    @GetMapping(value="/company")
    public ResponseMsg getAll(){
        return companyService.getAll();
    }


    @RequiresPermissions("companys:read")
    @GetMapping(value="/companys")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return companyService.getList(pageNum);
    }

    @RequiresPermissions("companys:searchByName:read")
    @GetMapping(value="/company/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name ){
        return companyService.searchByName(pageNum,name);
    }


}
