package com.beidou.position.websocket.entity;

import java.io.Serializable;
import io.netty.channel.Channel;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;

    private String userId;  // UID

    private String address;    // ip地址

    private Channel channel;// 通道

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
