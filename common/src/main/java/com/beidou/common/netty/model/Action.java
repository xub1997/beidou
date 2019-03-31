package com.beidou.common.netty.model;

public enum  Action {

    PUSHPOSITION(1),
    KEEPALIVE(2);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    Action(int code) {
        this.code = code;
    }
}
