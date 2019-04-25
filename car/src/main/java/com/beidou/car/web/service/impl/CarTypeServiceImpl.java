package com.beidou.car.web.service.impl;

import com.beidou.car.web.dao.CarTypeMapper;
import com.beidou.car.web.entity.CarType;
import com.beidou.car.web.service.CarTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CarTypeServiceImpl implements CarTypeService {
    @Autowired
    private CarTypeMapper carTypeMapper;

    /*
     * 保存车辆类型
     * */
    @Override
    public Integer insertCarType(CarType carType) {
        carType.setCarTypeId(UUID.randomUUID().toString().replaceAll("-","").substring(0,30));
        return carTypeMapper.insertSelective(carType);
    }

    /*
     * 更新车辆类型
     * */
    @Override
    public Integer updateCarType(CarType carType) {
        return carTypeMapper.updateByPrimaryKeySelective(carType);
    }

    /*
     * 删除车辆类型
     * */
    @Override
    public Integer deleteCarType(String typeId) {
        return carTypeMapper.deleteByPrimaryKey(typeId);
    }

    /*
     * 获取车辆类型
     * */
    @Override
    public CarType getCarType(String id) {
        return carTypeMapper.selectByPrimaryKey(id);
    }

    /*
     * 获取车辆类型列表（Map里面可以放各种条件）
     * */
    @Override
    public PageInfo listCarType(Map<String, Object> queryMap) {
        int pageNumber=1;
        int limit=10;
        if(queryMap.get("pageNumber")!=null&&queryMap.get("limit")!=null){
            pageNumber=Integer.parseInt(queryMap.get("pageNumber").toString());
            limit=Integer.parseInt(queryMap.get("limit").toString());
        }
        PageHelper.startPage(pageNumber, limit);//设置每页条数（传入页码）
        List<CarType> carTypes = carTypeMapper.listCarType(queryMap);
        PageInfo pageInfo = new PageInfo(carTypes, 5);
        return pageInfo;
    }

    /*
     * 获取全部车辆类型
     * */
    @Override
    public List<CarType> getAll() {
        return carTypeMapper.selectAll();
    }
}
