package com.beidou.carsocket.web.enums;

public enum  ActionType {

    LOGIN(1, "第一次(或重连)初始化连接"),
    KEEPALIVE(2, "客户端保持心跳"),
    SENDPOSITION(3,"发送定位"),
    GETPOSITION(4, "获取位置"),
    SENDMSG(5, "发送报警消息");

    public Integer type;
    public String content;

    ActionType(Integer type, String content){
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
