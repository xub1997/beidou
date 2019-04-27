package com.beidou.car.web.service.impl;

import com.beidou.car.web.dao.CarMapper;
import com.beidou.car.web.entity.Car;
import com.beidou.car.web.entity.vo.CarVO;
import com.beidou.car.web.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("carService")
public class CarServiceImpl implements CarService {


    @Autowired
    private CarMapper carMapper;

    /*
     * 保存车辆信息
     * */
    @Override
    public Integer insertCar(Car car) {
        car.setCarId(UUID.randomUUID().toString().replaceAll("-","").substring(0,30));
        car.setCreateTime(new Date());
        Integer flag=carMapper.insertSelective(car);
        return flag;
    }

    /*
     * 更新车辆信息
     * */
    @Override
    public Integer updateCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    /*
     * 删除车辆信息
     * */
    @Override
    public Integer deleteCar(String id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteCarBatch(String ids) {
        return carMapper.deleteByIds(ids);
    }

    /*
     * 获取车辆信息
     * */
    @Override
    public Car getCar(String id) {
        return carMapper.selectByPrimaryKey(id);
    }

    /*
     * 获取车辆列表（Map里面可以放各种条件）
     * */
    @Override
    public PageInfo listCar(Map<String, Object> queryMap) {
        int pageNumber=1;
        int limit=10;
        if(queryMap.get("pageNumber")!=null&&queryMap.get("limit")!=null){
            pageNumber=Integer.parseInt(queryMap.get("pageNumber").toString());
            limit=Integer.parseInt(queryMap.get("limit").toString());
        }
        PageHelper.startPage(pageNumber, limit);//设置每页条数（传入页码）
        List<CarVO> cars = carMapper.listCar(queryMap);
        PageInfo pageInfo = new PageInfo(cars, 5);
        return pageInfo;
    }
}
