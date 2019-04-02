package com.beidou.server;

public enum CarStatus {
    ONLINE(1),
    OFFLINE(2);
    private int code;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    CarStatus(int code) {
        this.code = code;
    }


}
