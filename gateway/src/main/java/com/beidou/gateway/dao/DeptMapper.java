package com.beidou.gateway.dao;


import com.beidou.gateway.entity.Dept;
import com.beidou.gateway.entity.DeptExample;
import com.beidou.gateway.entity.vo.DeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
    List<Dept> searchByNameAndComId(@Param("name") String name, @Param("comId") Integer comId);

    List<DeptVO> getAll();
}