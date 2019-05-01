package com.beidou.gateway.service;


import com.beidou.gateway.entity.CarPosition;
import com.beidou.gateway.entity.vo.CarPositionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(value = "car")
public interface CarPositionService {

    @PostMapping(value = "/carPosition")
    public Integer insert(CarPosition carPosition);


    @GetMapping(value = "/carPositions")
    public List<CarPositionVO> getList(@RequestParam Map<String, Object> queryMap);
}
