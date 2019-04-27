package com.beidou.carsocket.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan({"com.beidou.carsocket.*", "com.beidou.common.*"})
@SpringBootApplication
public class CarSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSocketApplication.class, args);
    }




}

