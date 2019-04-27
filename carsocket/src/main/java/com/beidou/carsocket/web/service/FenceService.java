package com.beidou.carsocket.web.service;


import com.beidou.carsocket.web.entity.Fence;
import com.github.pagehelper.PageInfo;


import java.util.Map;

public interface FenceService {
    /*
     * 保存围栏
     * */
    Integer insertFence(Fence fence);
    /*
     * 更新围栏
     * */
    Integer updateFence(Fence fence);
    /*
     * 删除围栏
     * */
    Integer deleteFence(Integer id);
    /*
     * 获取围栏
     * */
    Fence getFence(Integer id);
    /*
     * 获取围栏列表
     * */
    PageInfo listFence(Map<String,Object> queryMap);
}
