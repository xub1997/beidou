package com.beidou.gateway;

import com.beidou.common.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEncryptDecryptByBASE64(){
        String pwd="123";
        try {
            pwd= StringUtil.encryptByBASE64(pwd);
            System.out.println("加密为："+pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            pwd= StringUtil.decryptByBASE64(pwd);
            System.out.println("解密为："+pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
