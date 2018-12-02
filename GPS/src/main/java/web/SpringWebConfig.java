package web;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import web.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import web.conversion.DateConverter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import web.websocket.WebSocketSessionRegistry;

import java.nio.charset.Charset;
import java.util.List;


@Configuration
@ComponentScan
@EnableWebMvc
@EnableScheduling
public class SpringWebConfig  implements WebMvcConfigurer {

    private static final String CHARACTER_ENCODING = "UTF-8";

    private ApplicationContext applicationContext;

    //设置Spring应用上下文
    public void setApplicationContext(final ApplicationContext applicationContext)
    throws BeansException{
        this.applicationContext = applicationContext;
    }


    //配置静态资源处理器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    //消息国际化
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("GBK");
        messageSource.setBasename("message");
        return messageSource;
    }


    //配置格式转换类 注册为Bean后在thymeleaf即可使用
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
    }

    //spirng自动对指定字符串格式进行date转换
    @Bean
    public DateConverter dateConverter(){ return new DateConverter(); }


    //配置thymeleaf引擎和加载器
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(CHARACTER_ENCODING);
        //template cache 默认是true 如果想要template被修改的时候自动更新则设置成false
        templateResolver.setCacheable(true);
        return  templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("GBK");
        return viewResolver;
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());

    }

    @Bean
    public WebSocketSessionRegistry webSocketSessionRegistry(){
        return new WebSocketSessionRegistry();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(0, stringConverter);
    }
}
