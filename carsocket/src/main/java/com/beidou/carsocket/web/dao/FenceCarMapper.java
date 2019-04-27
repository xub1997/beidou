package com.beidou.carsocket.web.dao;

import com.beidou.carsocket.web.common.IBaseMapper;
import com.beidou.carsocket.web.entity.FenceCar;
import com.beidou.carsocket.web.entity.vo.FenceCarVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FenceCarMapper extends IBaseMapper<FenceCar> {
    List<FenceCarVO> listFenceCar(Map<String,Object> queryMap);
}