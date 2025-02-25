package com.example.demo.services;

import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserLogin;

import java.util.List;

public interface UserLoginServicesI {
    //查询
    public List<UserInfo> queryAll(String email, String password);
    //添加数据
    public int add(String email,String password);
    //根据用户名查询数据
    public UserLogin queryByName(String username);
    //将注册的用户添加进用户表
    public int addUser(String email,String password);
}
