package com.beidou.car.web.service;

import com.beidou.car.web.entity.CarType;
import com.github.pagehelper.PageInfo;

import java.util.List;
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
    Integer deleteCarType(String typeId);
    /*
    * 获取车辆类型
    * */
    CarType getCarType(String id);

    /*
    * 获取车辆类型列表（Map里面可以放各种条件）
    * */
    PageInfo listCarType(Map<String,Object> queryMap);

    /*
     * 获取全部车辆类型
     * */
    List<CarType> getAll();
}
