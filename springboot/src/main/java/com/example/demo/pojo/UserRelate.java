package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRelate {
    private String sendUserId;
    private  String receiveUserId;
    private  String lastTime;
    private String lastWord;
    private int sid;
}
