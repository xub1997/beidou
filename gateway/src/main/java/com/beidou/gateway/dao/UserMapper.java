package com.beidou.gateway.dao;


import com.beidou.gateway.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
@Mapper
public interface UserMapper {

    //查询用户角色、权限（登录用）
    User login(@Param("username") String username);

}