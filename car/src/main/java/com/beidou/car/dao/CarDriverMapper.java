package com.beidou.car.dao;

import com.beidou.car.entity.CarDriver;
import com.beidou.car.entity.CarDriverExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarDriverMapper {
    long countByExample(CarDriverExample example);

    int deleteByExample(CarDriverExample example);

    int insert(CarDriver record);

    int insertSelective(CarDriver record);

    List<CarDriver> selectByExample(CarDriverExample example);

    int updateByExampleSelective(@Param("record") CarDriver record, @Param("example") CarDriverExample example);

    int updateByExample(@Param("record") CarDriver record, @Param("example") CarDriverExample example);
}