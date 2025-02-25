package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatMessage {

    private Long id;
    private Long sendUserId;
    private Long receiveUserId;
    private String sendUserName;
    private String receiveUserName;
    private String sendContent;
    private LocalDateTime createTime;
    private String sendTime;
    private String sendUserAvatar;

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    // 构造方法、getter和setter省略

}