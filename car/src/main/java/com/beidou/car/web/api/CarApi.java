package com.beidou.car.web.api;

import com.beidou.car.web.entity.Car;
import com.beidou.car.web.service.CarService;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CarApi {
    @Autowired
    private CarService carService;


    @PostMapping(value = "/car")
    public Integer insert(Car car){
        return carService.insertCar(car);
    }



    @GetMapping(value="/car/{id}")
    public Car getById(@PathVariable("id")String carId){
        return carService.getCar(carId);
    }



    @PutMapping(value="/car/{id}")
    public Integer updateById(Car car){
        return carService.updateCar(car);
    }



    @DeleteMapping(value="/car/{id}")
    public Integer deleteByIds(@PathVariable("id")String carId){
        Integer flag = 0;
        if (!StringUtil.isEmpty(carId)) {

            //Integer carid = Integer.parseInt(id);
            flag = carService.deleteCar(carId);

        }
        return flag;
    }


    @GetMapping(value="/cars")
    public PageInfo getList(@RequestParam Map<String, Object> queryMap){
        return carService.listCar(queryMap);
    }

}
