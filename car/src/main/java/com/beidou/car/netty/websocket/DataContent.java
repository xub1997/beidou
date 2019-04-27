package com.beidou.car.netty.websocket;

import java.io.Serializable;

public class DataContent implements Serializable {

    private static final long serialVersionUID = 8021381444738260454L;
    private int action;
    private Content content;
    private String extend;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
