package com.beidou.car.web.api;

import com.beidou.car.web.entity.FenceCar;
import com.beidou.car.web.service.FenceCarService;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FenceCarApi {

    @Autowired
    private FenceCarService fenceCarService;

    @PostMapping(value = "/fenceCar")
    public Integer insert(FenceCar fenceCar) {
        Integer flag = fenceCarService.insertFenceCar(fenceCar);
        return flag;
    }


    @GetMapping(value = "/fenceCar/{id}")
    public FenceCar getById(@PathVariable("id") Integer id) {
        FenceCar fenceCar = fenceCarService.getFenceCar(id);
        return fenceCar;
    }


    @PutMapping(value = "/fenceCar/{id}")
    public Integer updateById(FenceCar fenceCar) {
        Integer flag = fenceCarService.updateFenceCar(fenceCar);
        return flag;
    }



    @DeleteMapping(value = "/fenceCar/{id}")
    public Integer deleteByIds(@PathVariable("id") String id) {
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {
            Integer typeId = Integer.parseInt(id);
            flag = fenceCarService.deleteFenceCar(typeId);
        }
        return flag;

    }

    @GetMapping(value = "/fenceCars")
    public ResponseMsg getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = fenceCarService.listFenceCar(queryMap);
        return ResponseMsg.Success("获取成功", pageInfo);
    }
}
