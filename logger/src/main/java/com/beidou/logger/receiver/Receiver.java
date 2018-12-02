package com.beidou.logger.receiver;

import com.alibaba.fastjson.JSON;
import com.beidou.logger.entity.SysLog;
import com.beidou.logger.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.concurrent.CountDownLatch;


@Component
@RabbitListener(queues = "syslog")
public class Receiver {

    private Logger logger= LoggerFactory.getLogger(Receiver.class);

    //等待一个线程
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private SysLogService sysLogService;

    @RabbitHandler
    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        SysLog sysLog=  JSON.parseObject(message,SysLog.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();
    }


}