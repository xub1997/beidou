package com.beidou.car.web.dao;

import com.beidou.car.web.common.IBaseMapper;
import com.beidou.car.web.entity.Car;
import com.beidou.car.web.entity.vo.CarVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CarMapper extends IBaseMapper<Car> {
    List<CarVO> listCar(Map<String,Object> queryMap);
}