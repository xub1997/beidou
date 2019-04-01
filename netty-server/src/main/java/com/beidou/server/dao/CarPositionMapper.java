package com.beidou.server.dao;

import com.beidou.server.common.IBaseMapper;
import com.beidou.server.entity.CarPosition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CarPositionMapper extends IBaseMapper<CarPosition> {
    List<CarPosition> listCarPosition(Map<String, Object> queryMap);
}