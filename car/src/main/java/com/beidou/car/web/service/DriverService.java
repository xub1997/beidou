package com.beidou.car.web.service;

import com.beidou.car.web.entity.vo.ComVO;
import com.beidou.car.web.entity.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DriverService {
    List<ComVO> getComs();
    List<UserVO> getComUser(Integer comId);
}
