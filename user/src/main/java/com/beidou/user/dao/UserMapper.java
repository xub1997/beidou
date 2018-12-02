package com.beidou.user.dao;

import com.beidou.user.entity.User;
import com.beidou.user.entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查找用户信息（用户详细信息、角色、权限）
    //User findByUsername(String username);

    //读取公司下面用户
    List<User> selectByComId(Integer comId);

    //根据用户名查询
    List<User> searchByUserName(String username);

    //根据用户名、公司编号查询
    List<User> searchByUserNameAndComId(@Param("username")String username,@Param("comId")Integer comId);

    //用户名查重
    User judgeUsername(String username);

}