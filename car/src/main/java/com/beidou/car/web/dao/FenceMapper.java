package com.beidou.car.web.dao;

import com.beidou.car.web.common.IBaseMapper;
import com.beidou.car.web.entity.Fence;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FenceMapper extends IBaseMapper<Fence> {
    List<Fence> listFence(Map<String,Object> queryMap);
}