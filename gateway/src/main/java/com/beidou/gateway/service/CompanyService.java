package com.beidou.gateway.service;



import com.beidou.common.entity.ResponseMsg;

import com.beidou.gateway.entity.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;



@Service
@FeignClient(value = "user")
public interface CompanyService {


    @PostMapping(value = "/company")
    public ResponseMsg insert(Company company);



    @GetMapping(value="/company/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id);


    @PutMapping(value="/company/{id}")
    public ResponseMsg updateById(Company company);



    @DeleteMapping(value="/company/{ids}")
    public ResponseMsg deleteByIds(@PathVariable("ids")String ids);


    @GetMapping(value="/company")
    public ResponseMsg getAll();



    @GetMapping(value="/companys")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum );


    @GetMapping(value="/company/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,@RequestParam(value = "name")String name );


}
