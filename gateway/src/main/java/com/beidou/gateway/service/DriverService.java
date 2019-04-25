package com.beidou.gateway.service;


import com.beidou.gateway.entity.vo.ComVO;
import com.beidou.gateway.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "car")
public interface DriverService {

    @GetMapping(value = "/com")
    public List<ComVO> getAllCom();

    @GetMapping(value = "/comUser")
    public List<UserVO> getAllComUser(@RequestParam("comId")Integer comId);
}
