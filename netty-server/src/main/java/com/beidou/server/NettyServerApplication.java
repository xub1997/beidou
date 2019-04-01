package com.beidou.server;

import com.beidou.common.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan(basePackages = {"com.beidou.common","com.beidou.server"})
@MapperScan("com.beidou.server.dao")
@SpringBootApplication
public class NettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);
    }

    @Bean
    public SpringUtil getSpingUtil() {
        return new SpringUtil();
    }

}
