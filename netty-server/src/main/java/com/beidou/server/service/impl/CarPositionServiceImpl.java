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


    /*
     * 获取车辆坐标列表（Map里面可以放各种条件）
     * */
    @Override
    public List<CarPosition> listCarPosition(Map<String, Object> queryMap) {
        List<CarPosition> carPositions = carPositionMapper.listCarPosition(queryMap);
        return carPositions;
    }
}
