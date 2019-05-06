package com.beidou.gateway.service;

import com.beidou.gateway.entity.CarType;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(value = "car")
public interface CarTypeService {


    @PostMapping(value = "/carType")
    public Integer insert(@RequestBody CarType carType);



    @GetMapping(value = "/carType/{id}")
    public CarType getById(@PathVariable("id") String id);


    @PutMapping(value = "/carType")
    public Integer updateById(@RequestBody CarType carType);



    @DeleteMapping(value = "/carType/{id}")
    public Integer deleteByIds(@PathVariable("id") String typeId);



    @GetMapping(value = "/carTypes")
    public PageInfo getList(@RequestParam Map<String, Object> queryMap);


    @GetMapping(value = "/carTypesAll")
    public List<CarType> getAll();
}
