package com.example.demo.controller;

import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserLogin;
import com.example.demo.services.UserLoginServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    UserLoginServicesImpl userLoginServicesImpl;

    @PostMapping("/toLogin")
    public List<UserInfo> toLogin(@RequestBody UserLogin userlogin ){
        System.out.println(userlogin.getEmail());
        System.out.println(userlogin.getPassword());
        List<UserInfo> userLogin1 = userLoginServicesImpl.queryAll(userlogin.getEmail(),userlogin.getPassword());
        System.out.println(userLogin1.size());
        return userLogin1;
    }
    //登录界面
    @PostMapping("/Register")
    public String toRegisterSuccess( @RequestBody UserLogin userLogin){
        //将账号密码加入到数据库中
        userLoginServicesImpl.add(userLogin.getEmail(), userLogin.getPassword());
        userLoginServicesImpl.addUser(userLogin.getEmail(), userLogin.getPassword());
        System.out.println("数据插入成功！");
        return "success";
    }
}
