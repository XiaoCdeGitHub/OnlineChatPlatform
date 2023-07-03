package com.example.demo.services;

import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServicesImpl implements UserLoginServicesI {

    @Autowired
    UserLoginMapper userLoginMapper;
    @Override
    public List<UserInfo> queryAll(String email, String password) {
        return userLoginMapper.queryAll(email,password);
    }

    @Override
    public int add(String email,String password) {
        return userLoginMapper.add(email,password);
    }

    @Override
    public UserLogin queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }
    @Override
    public int addUser(String email,String password){return  userLoginMapper.addUser(email,password);}
}
