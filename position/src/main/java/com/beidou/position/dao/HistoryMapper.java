package com.beidou.position.dao;

import com.beidou.position.common.IBaseMapper;
import com.beidou.position.entity.History;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryMapper extends IBaseMapper<History> {
}
