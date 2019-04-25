package com.beidou.car.web.api;

import com.beidou.car.web.entity.CarType;
import com.beidou.car.web.service.CarTypeService;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarTypeApi {

    @Autowired
    private CarTypeService carTypeService;


    @PostMapping(value = "/carType")
    public Integer insert(CarType carType) {
        Integer flag = carTypeService.insertCarType(carType);
        return flag;
    }



    @GetMapping(value = "/carType/{id}")
    public CarType getById(@PathVariable("id") String id) {
        CarType carType = carTypeService.getCarType(id);
        return carType;
    }


    @PutMapping(value = "/carType/{id}")
    public Integer updateById(CarType carType) {
        Integer flag = carTypeService.updateCarType(carType);
        return flag;
    }



    @DeleteMapping(value = "/carType/{id}")
    public Integer deleteByIds(@PathVariable("id") String typeId) {
        Integer flag = 0;
        if (!StringUtil.isEmpty(typeId)) {

            flag = carTypeService.deleteCarType(typeId);
        }
        return flag;

    }



    @GetMapping(value = "/carTypes")
    public PageInfo getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = carTypeService.listCarType(queryMap);
        return pageInfo;
    }


    @GetMapping(value = "/carTypesAll")
    public List<CarType> getAll() {
        List<CarType> carTypes = carTypeService.getAll();
        return carTypes;
    }
}
