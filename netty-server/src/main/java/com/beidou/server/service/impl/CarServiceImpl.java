package com.beidou.server.service.impl;


import com.beidou.server.dao.CarMapper;
import com.beidou.server.entity.Car;
import com.beidou.server.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("carService")
public class CarServiceImpl implements CarService {


    @Autowired
    private CarMapper carMapper;



    /*
     * 更新车辆信息
     * */
    @Override
    public Integer updateCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }




}
