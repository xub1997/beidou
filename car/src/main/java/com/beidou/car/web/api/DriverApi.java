package com.beidou.car.web.api;

import com.beidou.car.web.entity.vo.ComVO;
import com.beidou.car.web.entity.vo.UserVO;
import com.beidou.car.web.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverApi {

    @Autowired
    private DriverService driverService;

    @GetMapping(value = "/com")
    public List<ComVO> getAllCom() {
        List<ComVO> coms = driverService.getComs();
        return coms;
    }


    @GetMapping(value = "/comUser")
    public List<UserVO> getAllComUser(@RequestParam("comId")Integer comId) {
        List<UserVO> userVOS = driverService.getComUser(comId);
        return userVOS;
    }
}
