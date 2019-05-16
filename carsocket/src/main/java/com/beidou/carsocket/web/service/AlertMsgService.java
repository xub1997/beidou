package com.beidou.carsocket.web.service;

import com.beidou.carsocket.web.entity.AlertMsg;

import java.util.List;

public interface AlertMsgService {
    public void insert(AlertMsg alertMsg);
    public void update(String idsString);
    public List<AlertMsg> getAlertMsg();
}
