package com.beidou.car.web.service;


import com.beidou.car.web.entity.FenceCar;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface FenceCarService {

    /*
     * 保存围栏车辆
     * */
    Integer insertFenceCar(FenceCar fenceCar);
    /*
     * 更新围栏车辆
     * */
    Integer updateFenceCar(FenceCar fenceCar);
    /*
     * 删除围栏车辆
     * */
    Integer deleteFenceCar(Integer id);
    /*
     * 获取围栏车辆
     * */
    FenceCar getFenceCar(Integer id);
    /*
     * 获取围栏车辆列表
     * */
    PageInfo listFenceCar(Map<String,Object> queryMap);

}
