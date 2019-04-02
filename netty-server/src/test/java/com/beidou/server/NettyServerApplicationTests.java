package com.beidou.server;

import com.beidou.server.dao.CarPositionMapper;
import com.beidou.server.entity.CarPosition;
import com.beidou.server.service.CarPositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NettyServerApplicationTests {

    @Autowired
    CarPositionMapper carPositionMapper;

    @Test
    public void contextLoads() {

        CarPosition carPosition=carPositionMapper.getLastPosition("123");
        System.out.println(carPosition.getLon()+","+carPosition.getLat()+","+carPosition.getUtcTime());
        CarPosition carPosition11=new CarPosition();
        carPosition11.setUtcTime(new Date());
        int flag=carPositionMapper.insertSelective(carPosition11);
        System.out.println();
    }

}
