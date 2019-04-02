package com.beidou.server.service;

import com.beidou.server.entity.CarPosition;

import java.util.List;
import java.util.Map;

public interface CarPositionService {
    /*
    * 保存车辆坐标
    * */
    Integer insertCarPosition(CarPosition carPosition);

    CarPosition getLastPosition(String carId);
}
