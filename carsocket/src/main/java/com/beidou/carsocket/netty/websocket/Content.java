package com.beidou.carsocket.netty.websocket;

import java.io.Serializable;

public class Content implements Serializable {

    private static final long serialVersionUID = 3611169682695799175L;

    private String carId;
    private int comId;
    private String msg;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
