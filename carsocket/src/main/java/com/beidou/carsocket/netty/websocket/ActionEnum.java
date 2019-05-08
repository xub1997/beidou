package com.beidou.carsocket.netty.websocket;

public enum ActionEnum {
    CONNECT(1),  //第一次(或重连)初始化连接
    KEEPALIVE(2),  //客户端保持心跳
    DISCONNECT(3),                //断开连接
    GETCARLIST(4),               //获取车辆列表
    GETCARSTATE(5),            //获取车辆状态
    GETLASTPOSITION(6),     //获取最新车辆位置
    CARLOGIN(7),           //上线
    CARLOGOUT(8),           //下线
    SENDPOSITION(9);       //获取车辆的最新位置
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ActionEnum(int type) {
        this.type = type;
    }

    public static ActionEnum fromType(int type) {
        for (ActionEnum actionEnum : values()) {
            if (actionEnum.getType()==type) {
                return actionEnum;
            }
        }
        return null;
    }
}
