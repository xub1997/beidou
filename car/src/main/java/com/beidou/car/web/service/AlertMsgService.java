package com.beidou.car.web.service;



import com.beidou.car.web.entity.AlertMsg;

import java.util.List;

public interface AlertMsgService {
    public void insert(AlertMsg alertMsg);
    public void update(String idsString);
    public List<AlertMsg> getAlertMsg();
}
