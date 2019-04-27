package com.beidou.carsocket.web.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {


    /**
     * 配置静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        super.addResourceHandlers(registry);
    }

    /**
     * 配置跨域CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// CORS 配置对所有接口都有效
                .allowedOrigins("*")//允许任意域名
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//表明服务器支持的请求类型
                .maxAge(3600)//预检请求的有效期，单位为秒。
                .allowCredentials(true);//它的值只有一个就是 true。跨站点带验证信息时，服务器必须要争取设置这个值，服务器才能获取到部门-公司管理的cookie。
    }



}
