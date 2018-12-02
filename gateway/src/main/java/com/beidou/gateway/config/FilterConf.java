package com.beidou.gateway.config;



import com.beidou.gateway.filter.RequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FilterConf {
    @Bean
    public RequestFilter filter(){
        return  new RequestFilter() ;
    }
}
