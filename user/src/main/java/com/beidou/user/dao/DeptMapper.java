package com.beidou.user.dao;

import com.beidou.user.entity.Dept;
import com.beidou.user.entity.DeptExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    //公司下属部门
    List<Dept> selectByComId(Integer comId);


    //根据部门名查询
    List<Dept> searchByName(String name);

    //根据部门名、公司编号查询
    List<Dept> searchByNameAndComId(@Param("name")String name,@Param("comId")Integer comId);
}