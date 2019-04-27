package com.beidou.carsocket.web.service.impl;

import com.beidou.carsocket.web.dao.DriverMapper;
import com.beidou.carsocket.web.entity.vo.ComVO;
import com.beidou.carsocket.web.entity.vo.UserVO;
import com.beidou.carsocket.web.service.DriverService;
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
