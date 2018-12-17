package com.beidou.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/*import org.springframework.cloud.openfeign.EnableFeignClients;*/
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
/*@EnableFeignClients*/
@EnableDiscoveryClient
@ComponentScan({"com.beidou.gateway.*", "com.beidou.common.*","com.beidou.gateway.config.*"})
@MapperScan("com.beidou.gateway.dao.*")
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
