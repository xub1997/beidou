package com.beidou.car.web.service;

import com.beidou.car.web.entity.CarType;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface CarTypeService {
    /*
    * 保存车辆类型
    * */
    Integer insertCarType(CarType carType);
    /*
    * 更新车辆类型
    * */
    Integer updateCarType(CarType carType);
    /*
    * 删除车辆类型
    * */
    Integer deleteCarType(Integer id);
    /*
    * 获取车辆类型
    * */
    CarType getCarType(Integer id);

    /*
    * 获取车辆类型列表（Map里面可以放各种条件）
    * */
    PageInfo listCarType(Map<String,Object> queryMap);
}
