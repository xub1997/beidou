package com.beidou.car.web.service.impl;

import com.beidou.car.web.dao.FenceCarMapper;
import com.beidou.car.web.entity.FenceCar;
import com.beidou.car.web.entity.vo.FenceCarVO;
import com.beidou.car.web.service.FenceCarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FenceCarServiceImpl implements FenceCarService {

    @Autowired
    private FenceCarMapper fenceCarMapper;

    /*
     * 保存围栏车辆
     * */
    @Override
    public Integer insertFenceCar(FenceCar fenceCar) {
        return fenceCarMapper.insertSelective(fenceCar);
    }

    /*
     * 更新围栏车辆
     * */
    @Override
    public Integer updateFenceCar(FenceCar fenceCar) {
        return fenceCarMapper.updateByPrimaryKeySelective(fenceCar);
    }

    /*
     * 删除围栏车辆
     * */
    @Override
    public Integer deleteFenceCar(Integer id) {
        return fenceCarMapper.deleteByPrimaryKey(id);
    }

    /*
     * 获取围栏车辆
     * */
    @Override
    public FenceCar getFenceCar(Integer id) {
        return fenceCarMapper.selectByPrimaryKey(id);
    }

    /*
     * 获取围栏车辆列表
     * */
    @Override
    public PageInfo listFenceCar(Map<String, Object> queryMap) {
        int pageNumber=1;
        int limit=10;
        if(queryMap.get("pageNumber")!=null&&queryMap.get("limit")!=null){
            pageNumber=Integer.parseInt(queryMap.get("pageNumber").toString());
            limit=Integer.parseInt(queryMap.get("limit").toString());
        }
        PageHelper.startPage(pageNumber, limit);//设置每页条数（传入页码）
        List<FenceCarVO> fenceCars = fenceCarMapper.listFenceCar(queryMap);
        PageInfo pageInfo = new PageInfo(fenceCars, 5);
        return pageInfo;
    }
}
