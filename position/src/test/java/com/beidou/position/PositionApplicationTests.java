package com.beidou.position;

import com.beidou.position.business.service.HistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionApplicationTests {
    @Autowired
    HistoryService historyService;

    @Test
    public void contextLoads() {
        System.out.println(historyService.getByCarId(1));
    }


}

