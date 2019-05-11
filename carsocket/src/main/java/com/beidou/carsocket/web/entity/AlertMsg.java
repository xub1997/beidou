package com.beidou.carsocket.web.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_alert_msg")
public class AlertMsg {
    /**
     * 消息编号
     */
    @Id
    @Column(name = "alert_id")
    private Integer alertId;


    /**
     * 消息
     */
    @Column(name = "msg")
    private String msg;

    /**
     * 消息状态（0：未读  1：已读）
     */
    @Column(name = "status")
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
