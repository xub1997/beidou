package com.beidou.server.service.impl;


import com.beidou.server.dao.CarPositionMapper;
import com.beidou.server.entity.CarPosition;
import com.beidou.server.service.CarPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("carPositionService")
public class CarPositionServiceImpl implements CarPositionService {

    @Autowired
    private CarPositionMapper carPositionMapper;

    /*
     * 保存车辆坐标
     * */
    @Override
    public Integer insertCarPosition(CarPosition carPosition) {
        carPosition.setReceiveTime(new Date());
        Integer flag=carPositionMapper.insertSelective(carPosition);
        return flag;
    }


    @Override
    public CarPosition getLastPosition(String carId) {
        return carPositionMapper.getLastPosition(carId);
    }
}
