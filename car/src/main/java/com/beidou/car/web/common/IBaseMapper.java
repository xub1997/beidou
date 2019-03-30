package com.beidou.car.web.common;


import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface IBaseMapper<T>   extends BaseMapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}
