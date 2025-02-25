package com.example.demo.services;

import com.example.demo.pojo.FriendList;
import com.example.demo.pojo.UserInfo;
import com.example.demo.pojo.UserRelate;

import java.util.List;

public interface UserInfoServicesI {
    //    更新用户信息
    public int updateUserInfo(int userId,String name,String gender,String region,String avatar);
    //    获取所有好友
    public List<FriendList> getAllFriends(String userId);
    //    通过id查询用户
    public UserInfo getUserInfoById(int userId);
    //    通过名称查询用户
    public List<UserInfo> getUserInfoByName(String name);
    //    通过邮箱查询用户
    public UserInfo getUserInfoByEmail(String email);
    //    添加好友
    public int addFriend(String sendUserId,String receiveUserId,String lastTime);
    //    检查是否已经添加了好友
    public List<UserRelate> checkFriendState(String sendUserId, String receiveUserId);
}
