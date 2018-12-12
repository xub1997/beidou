package com.beidou.gateway.service;

import com.beidou.gateway.dao.UserMapper;
import com.beidou.gateway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username){
        return userMapper.login(username);
    }
}
