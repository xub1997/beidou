package com.beidou.common.sender;

import com.alibaba.fastjson.JSON;
import com.beidou.common.config.RabbitConfig;
import com.beidou.common.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private  AmqpTemplate rabbitTemplate;

    public void sendMessage(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, JSON.toJSONString(sysLog));
        /*rabbitTemplate.convertAndSend(RabbitConfig.queueName, sysLog);*/
    }

}
