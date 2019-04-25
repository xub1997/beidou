package com.beidou.car.web.service.impl;

import com.beidou.car.web.dao.DriverMapper;
import com.beidou.car.web.entity.vo.ComVO;
import com.beidou.car.web.entity.vo.UserVO;
import com.beidou.car.web.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public List<ComVO> getComs() {
        return driverMapper.getComs();
    }

    @Override
    public List<UserVO> getComUser(Integer comId) {
        return driverMapper.getComUser(comId);
    }
}
