package com.beidou.position.business.common;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface IBaseMapper<T>   extends BaseMapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}
