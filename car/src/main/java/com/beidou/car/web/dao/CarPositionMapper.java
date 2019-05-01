package com.beidou.car.web.dao;

import com.beidou.car.web.common.IBaseMapper;
import com.beidou.car.web.entity.CarPosition;
import com.beidou.car.web.entity.vo.CarPositionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CarPositionMapper extends IBaseMapper<CarPosition> {
    List<CarPositionVO> listCarPosition(Map<String,Object> queryMap);
    CarPositionVO getLastCarPosition(@Param("carId") String carId);
}