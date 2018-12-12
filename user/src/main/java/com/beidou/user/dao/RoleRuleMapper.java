package com.beidou.user.dao;

import com.beidou.user.entity.RoleRule;
import com.beidou.user.entity.RoleRuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@Mapper
public interface RoleRuleMapper {
    long countByExample(RoleRuleExample example);

    int deleteByExample(RoleRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleRule record);

    int insertSelective(RoleRule record);

    List<RoleRule> selectByExample(RoleRuleExample example);

    RoleRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleRule record, @Param("example") RoleRuleExample example);

    int updateByExample(@Param("record") RoleRule record, @Param("example") RoleRuleExample example);

    int updateByPrimaryKeySelective(RoleRule record);

    int updateByPrimaryKey(RoleRule record);

    //批量添加
    int batchInsert(List<RoleRule> roleRules);
}