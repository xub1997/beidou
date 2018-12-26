package com.beidou.position.common;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface IBaseMapper<T>   extends BaseMapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}
