package com.beidou.position.business.dao;

import com.beidou.position.business.common.IBaseMapper;
import com.beidou.position.business.entity.History;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryMapper extends IBaseMapper<History> {
}
