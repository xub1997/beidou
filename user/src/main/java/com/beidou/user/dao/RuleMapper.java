package com.beidou.user.dao;

import com.beidou.user.entity.Rule;
import com.beidou.user.entity.RuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
@Mapper
public interface RuleMapper {
    long countByExample(RuleExample example);

    int deleteByExample(RuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rule record);

    int insertSelective(Rule record);

    List<Rule> selectByExample(RuleExample example);

    Rule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rule record, @Param("example") RuleExample example);

    int updateByExample(@Param("record") Rule record, @Param("example") RuleExample example);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);

    //角色对应权限
    List<Rule> getRoleRule(Integer roleIds);

    //根据权限名查询
    List<Rule> searchByName(String name);
}