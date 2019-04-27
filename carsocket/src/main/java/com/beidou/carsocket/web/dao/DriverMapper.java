package com.beidou.carsocket.web.dao;

import com.beidou.carsocket.web.entity.vo.ComVO;
import com.beidou.carsocket.web.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DriverMapper {
    @Select("select id,name from tb_company")
    List<ComVO> getComs();

    @Select("select id,name from tb_user where comId=#{comId}")
    List<UserVO> getComUser(@Param("comId")Integer comId);

}
