package com.beidou.carsocket.web.service;

import com.beidou.carsocket.web.entity.vo.ComVO;
import com.beidou.carsocket.web.entity.vo.UserVO;

import java.util.List;


public interface DriverService {
    List<ComVO> getComs();
    List<UserVO> getComUser(Integer comId);
}
