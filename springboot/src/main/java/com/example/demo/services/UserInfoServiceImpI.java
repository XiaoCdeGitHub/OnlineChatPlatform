package com.example.demo.services;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.FriendList;
import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserRelate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpI implements  UserInfoServicesI{
    @Autowired
    UserInfoMapper userInfoMapper;
    //    更新用户信息
    @Override
    public int updateUserInfo(int userId,String name,String gender,String region,String avatar){
        return userInfoMapper.updateUserInfo(userId,name,gender,region,avatar);
    }
    //    获取所有好友
    @Override
    public List<FriendList> getAllFriends(String userId){return  userInfoMapper.getAllFriends(userId);};
    //    通过id查询用户
    @Override
    public UserInfo getUserInfoById(int userId){
        return userInfoMapper.getUserInfoById(userId);
    }
    //    通过名称查询用户
    @Override
    public List<UserInfo> getUserInfoByName(String name){
        return userInfoMapper.getUserInfoByName(name);
    }
    //    通过邮箱查询用户
    @Override
    public UserInfo getUserInfoByEmail(String email){
        return userInfoMapper.getUserInfoByEmail(email);
    }
    //    添加好友
    @Override
    public int addFriend(String sendUserId,String receiveUserId,String lastTime)
        {return  userInfoMapper.addFriend(sendUserId,receiveUserId,lastTime);};
    //    检查是否已经添加了好友
    @Override
    public List<UserRelate> checkFriendState(String sendUserId, String receiveUserId){
        return userInfoMapper.checkFriendState(sendUserId,receiveUserId);
    };
}
