package com.beidou.logger.dao;

import com.beidou.logger.entity.SysLog;
import com.beidou.logger.entity.SysLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SysLogMapper {


    int insert(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    List<SysLog> selectAll();

    List<SysLog> selectByUsername(String username);

    List<SysLog> searchByUsername(String username);

}