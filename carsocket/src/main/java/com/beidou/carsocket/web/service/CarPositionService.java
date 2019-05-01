package com.beidou.carsocket.web.service;

import com.beidou.carsocket.web.entity.CarPosition;
import com.beidou.carsocket.web.entity.vo.CarPositionVO;

import java.util.List;
import java.util.Map;

public interface CarPositionService {
    /*
    * 保存车辆坐标
    * */
    Integer insertCarPosition(CarPosition carPosition);

    /*
    * 获取车辆坐标列表（Map里面可以放各种条件）
    * */
    List<CarPositionVO> listCarPosition(Map<String,Object> queryMap);

    /*
    * 获取最新位置
    * */
    CarPositionVO getLastCarPosition(String carId);
}
