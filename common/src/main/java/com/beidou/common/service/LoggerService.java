package com.beidou.common.service;


import com.beidou.common.entity.SysLog;
import com.beidou.common.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoggerService {

    @Autowired
    private Sender sender;

    public void savelog(SysLog sysLog){
        sender.sendMessage(sysLog);
        System.out.println("发送操作日志");
    }
}
