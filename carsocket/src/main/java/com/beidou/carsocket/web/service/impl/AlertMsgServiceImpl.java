package com.beidou.carsocket.web.service.impl;

import com.beidou.carsocket.web.dao.AlertMsgMapper;
import com.beidou.carsocket.web.entity.AlertMsg;
import com.beidou.carsocket.web.service.AlertMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertMsgServiceImpl implements AlertMsgService {

    @Autowired
    private AlertMsgMapper alertMsgMapper;

    @Override
    public void insert(AlertMsg alertMsg) {
        alertMsg.setStatus(0);
        alertMsgMapper.insertSelective(alertMsg);
    }

    @Override
    public void update(String idsString) {
        String[] ids =idsString.split(",");
        Integer[] idsList=null;
        AlertMsg alertMsg=new AlertMsg();
        for(int i=0;i<ids.length;i++){
            alertMsg.setAlertId(Integer.parseInt(ids[i]));
            alertMsg.setStatus(1);
            alertMsgMapper.updateByPrimaryKeySelective(alertMsg);
        }
    }

    @Override
    public List<AlertMsg> getAlertMsg() {
        List<AlertMsg> result=null;
        AlertMsg alertMsg=new AlertMsg();
        alertMsg.setStatus(0);
        result = alertMsgMapper.select(alertMsg);
        return result;
    }
}
