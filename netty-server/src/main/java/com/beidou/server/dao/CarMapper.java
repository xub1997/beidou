package com.beidou.server.dao;


import com.beidou.server.common.IBaseMapper;
import com.beidou.server.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CarMapper extends IBaseMapper<Car> {
}