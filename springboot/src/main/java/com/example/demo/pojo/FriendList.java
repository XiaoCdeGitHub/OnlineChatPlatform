package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendList {
    private String name;
    private String avatar;
    private  String lastWord;
    private  String lastTime;
    private  int userId;
}
