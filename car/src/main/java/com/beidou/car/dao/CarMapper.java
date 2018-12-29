package com.beidou.car.dao;

import com.beidou.car.entity.Car;
import com.beidou.car.entity.CarExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarMapper {
    long countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer carid);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}