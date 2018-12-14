package com.beidou.gateway.config;



import com.beidou.gateway.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FilterConf {
    @Bean
    public AuthFilter filter(){
        return  new AuthFilter() ;
    }
}
