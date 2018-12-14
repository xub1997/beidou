package com.beidou.gateway.service;

import com.beidou.gateway.dao.LoginMapper;
import com.beidou.gateway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper userMapper;

    public User login(String username){
        return userMapper.login(username);
    }
}
