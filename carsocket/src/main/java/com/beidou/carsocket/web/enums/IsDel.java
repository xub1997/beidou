package com.beidou.carsocket.web.enums;

public enum  IsDel {
    Yes(1),//已删除
    NO(0);//未删除
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    IsDel(int code) {
        this.code = code;
    }
}
