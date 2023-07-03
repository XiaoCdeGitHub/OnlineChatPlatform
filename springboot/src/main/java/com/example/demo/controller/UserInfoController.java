package com.example.demo.controller;

import com.example.demo.pojo.FriendList;
import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserLogin;
import com.example.demo.pojo.UserRelate;
import com.example.demo.services.UserInfoServicesI;
import com.example.demo.services.UserLoginServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserInfoController {
    @Autowired
    UserInfoServicesI userInfoServicesI;

    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody UserInfo userInfo){
       userInfoServicesI.updateUserInfo(userInfo.getUserId(), userInfo.getName(),
                                        userInfo.getGender(), userInfo.getRegion(),
                                        userInfo.getAvatar());
       System.out.println(userInfo.toString());
        return "success";
    }
    @GetMapping("/getAllFriends")
    public List<FriendList> getAllFriends(@RequestParam("id") String userId){
        List<FriendList> friendList=userInfoServicesI.getAllFriends(userId);
        System.out.println(friendList.toString());
        return friendList;
    }
    @GetMapping("/getUserInfoById")
    public UserInfo getUserInfoById(@RequestParam("id") int userId){
        return userInfoServicesI.getUserInfoById(userId);
    }
    @GetMapping("/getUserInfoByEmail")
    public UserInfo getUserInfoByEmail(@RequestParam("email") String email){
        return userInfoServicesI.getUserInfoByEmail(email);
    }
    @PostMapping("/addFriend")
    public int addFriend(@RequestBody UserRelate userRelate){
        List<UserRelate> result=userInfoServicesI.checkFriendState(userRelate.getSendUserId(),userRelate.getReceiveUserId());
        List<UserRelate> result2=userInfoServicesI.checkFriendState(userRelate.getSendUserId(),userRelate.getReceiveUserId());
        System.out.println(result.size());
        System.out.println(result2.size());
        if(result.size()==0){
            userInfoServicesI.addFriend(userRelate.getReceiveUserId(),
                    userRelate.getSendUserId(),userRelate.getLastTime());
        }
        if(result2.size()==0){
            userInfoServicesI.addFriend(userRelate.getSendUserId(),
                    userRelate.getReceiveUserId(),userRelate.getLastTime());
        }
        return 1;
    }
}
