package com.beidou.car.web.service.impl;

import com.beidou.car.web.dao.FenceMapper;
import com.beidou.car.web.entity.Fence;
import com.beidou.car.web.service.FenceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FenceServiceImpl implements FenceService {
    @Autowired
    private FenceMapper fenceMapper;

    /*
     * 保存围栏
     * */
    @Override
    public Integer insertFence(Fence fence) {
        fence.setCreateTime(new Date());
        fence.setModifyTime(new Date());
        Integer flag=fenceMapper.insertSelective(fence);
        return flag;
    }

    /*
     * 更新围栏
     * */
    @Override
    public Integer updateFence(Fence fence) {
        fence.setModifyTime(new Date());
        Integer flag=fenceMapper.updateByPrimaryKeySelective(fence);
        return flag;
    }

    /*
     * 删除围栏
     * */
    @Override
    public Integer deleteFence(Integer id) {
        return fenceMapper.deleteByPrimaryKey(id);
    }

    /*
     * 获取围栏
     * */
    @Override
    public Fence getFence(Integer id) {
        return fenceMapper.selectByPrimaryKey(id);
    }

    /*
     * 获取围栏列表
     * */
    @Override
    public PageInfo listFence(Map<String, Object> queryMap) {
        int pageNumber=1;
        int limit=10;
        if(queryMap.get("pageNumber")!=null&&queryMap.get("limit")!=null){
            pageNumber=Integer.parseInt(queryMap.get("pageNumber").toString());
            limit=Integer.parseInt(queryMap.get("limit").toString());
        }
        PageHelper.startPage(pageNumber, limit);//设置每页条数（传入页码）
        List<Fence> fences = fenceMapper.listFence(queryMap);
        PageInfo pageInfo = new PageInfo(fences, 5);
        return pageInfo;
    }
}
