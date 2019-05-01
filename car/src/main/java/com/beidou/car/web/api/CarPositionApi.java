package com.beidou.car.web.api;

import com.beidou.car.web.entity.CarPosition;
import com.beidou.car.web.entity.vo.CarPositionVO;
import com.beidou.car.web.service.CarPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CarPositionApi {
    @Autowired
    private CarPositionService carPositionService;


    @PostMapping(value = "/carPosition")
    public Integer insert(CarPosition carPosition) {
        Integer flag = carPositionService.insertCarPosition(carPosition);
        return flag;
    }



    @GetMapping(value = "/carPositions")
    public List<CarPositionVO> getList(@RequestParam Map<String, Object> queryMap) {
        List<CarPositionVO> carPositions= carPositionService.listCarPosition(queryMap);
        return carPositions;
    }
}
