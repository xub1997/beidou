package com.beidou.car.web.dao;

import com.beidou.car.web.common.IBaseMapper;
import com.beidou.car.web.entity.CarType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CarTypeMapper extends IBaseMapper<CarType> {
    List<CarType> listCarType(Map<String,Object> queryMap);
}