package com.beidou.car.web.api;

import com.beidou.car.web.entity.Fence;
import com.beidou.car.web.service.FenceService;
import com.beidou.common.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FenceApi {
    @Autowired
    private FenceService fenceService;


    @PostMapping(value = "/fence")
    public Integer insert(Fence fence) {
        Integer flag = fenceService.insertFence(fence);
        return flag;
    }


    @GetMapping(value = "/fence/{id}")
    public Fence getById(@PathVariable("id") Integer id) {
        Fence fence = fenceService.getFence(id);
        return fence;
    }



    @PutMapping(value = "/fence/{id}")
    public Integer updateById(Fence fence) {
        Integer flag = fenceService.updateFence(fence);
        return flag;
    }



    @DeleteMapping(value = "/fence/{id}")
    public Integer deleteByIds(@PathVariable("id") String id) {
        Integer flag = 0;
        if (!StringUtil.isEmpty(id)) {

            Integer typeId = Integer.parseInt(id);
            flag = fenceService.deleteFence(typeId);

        }
        return flag;
    }


    @GetMapping(value = "/fences")
    public PageInfo getList(@RequestParam Map<String, Object> queryMap) {
        PageInfo pageInfo = fenceService.listFence(queryMap);
        return pageInfo;
    }
}
