package com.beidou.gateway.entity;



public class AlertMsg {
    /**
     * 消息编号
     */
    private Integer alertId;


    /**
     * 消息
     */
    private String msg;

    /**
     * 消息状态（0：未读  1：已读）
     */
    private Integer status;

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
