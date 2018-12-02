package com.beidou.user.config;




import com.beidou.user.interceptor.LoginInterCeption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new LoginInterCeption()).addPathPatterns("/**")//**代表所有URL请求
                                                    .excludePathPatterns("/setServiceOn/*") //(排除)
                                                    .excludePathPatterns("/offline"); //(排除)

        super.addInterceptors(registry);
    }

    /**
     * 配置静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/error/")
                .addResourceLocations("classpath:/templates/error/");
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

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".jsp");
        resolver.setViewNames("/*");
        resolver.setOrder(2);
        return resolver;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolverThymeLeaf() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("utf-8");
        viewResolver.setViewNames(new String[]{"/*"});
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
                container.addErrorPages(error400Page, error401Page, error404Page, error500Page);
            }
        };
    }*/

}
