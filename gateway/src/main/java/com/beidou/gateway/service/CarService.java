package com.beidou.gateway.service;


import com.beidou.gateway.entity.Car;
import com.beidou.gateway.entity.vo.CarVO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(value = "car")
public interface CarService {

    @PostMapping(value = "/car")
    public Integer insert(Car car);



    @GetMapping(value="/car/{id}")
    public Car getById(@PathVariable("id")String carId);



    @PutMapping(value="/car/{id}")
    public Integer updateById(Car car);



    @DeleteMapping(value="/car/{id}")
    public Integer deleteByIds(@PathVariable("id")String carId);


    @GetMapping(value="/cars")
    public PageInfo getList(@RequestParam Map<String, Object> queryMap);

    @GetMapping(value = "/getCarList")
    public List<CarVO> listCar(@RequestParam Map<String, Object> queryMap);

}
