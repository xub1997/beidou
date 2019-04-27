package com.beidou.carsocket.web.api;

import com.beidou.carsocket.web.dao.CarMapper;
import com.beidou.carsocket.web.entity.Car;
import com.beidou.carsocket.web.entity.vo.CarVO;
import com.beidou.carsocket.web.service.CarService;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarApi {
    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;


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

    @GetMapping(value = "/getCarList")
    public List<CarVO> listCar(@RequestParam Map<String, Object> queryMap){
        return carMapper.listCar(queryMap);
    }

}
