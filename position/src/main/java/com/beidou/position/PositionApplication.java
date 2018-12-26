package com.beidou.position;

import com.beidou.position.common.IBaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "com.beidou.position.dao",markerInterface = IBaseMapper.class)
@ComponentScan(basePackages = {"com.beidou.position.common","com.beidou.position"})
@EnableTransactionManagement
@SpringBootApplication
public class PositionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PositionApplication.class, args);
    }

}

