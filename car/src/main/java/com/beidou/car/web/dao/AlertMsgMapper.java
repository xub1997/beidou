package com.beidou.car.web.dao;


import com.beidou.car.web.common.IBaseMapper;
import com.beidou.car.web.entity.AlertMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AlertMsgMapper extends IBaseMapper<AlertMsg> {

}
