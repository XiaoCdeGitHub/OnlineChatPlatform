package com.example.demo.mapper;

import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    //查询
    public List<UserInfo> queryAll(String email, String password);
    //添加数据
    public int add(String email,String password);
    //根据用户名查询数据
    public UserLogin queryByName(String username);
    public int addUser(String email,String password);
}
