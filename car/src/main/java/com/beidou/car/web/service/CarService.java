package com.beidou.car.web.service;

import com.beidou.car.web.entity.Car;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface CarService {
    /*
    * 保存车辆信息
    * */
    Integer insertCar(Car car);
    /*
    * 更新车辆信息
    * */
    Integer updateCar(Car car);
    /*
    * 删除车辆信息
    * */
    Integer deleteCar(String id);

    /*
     * 批量删除车辆信息
     * */
    Integer deleteCarBatch(String ids);

    /*
    * 获取车辆信息
    * */
    Car getCar(String carId);
    /*
    * 获取车辆列表（Map里面可以放各种条件）
    * */
    PageInfo listCar(Map<String,Object> queryMap);
}
