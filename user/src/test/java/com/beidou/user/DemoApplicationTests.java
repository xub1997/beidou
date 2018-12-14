package com.beidou.user;


import com.beidou.common.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPwd(){
        System.out.println(StringUtil.encryptByMD5("345"+"63856b59-dd15-4d64-a2eb-ba7601c4c87b"));
    }

}
