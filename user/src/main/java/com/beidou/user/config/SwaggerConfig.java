package com.beidou.user.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .apis(RequestHandlerSelectors.basePackage("com.beidou.user"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {   // 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("用户管理api")  // API 标题
                .description("用户管理接口文档说明")  // API 描述
                .contact(new Contact("xub", "", "836192293@qq.com"))//联系人
                .version("1.0") //版本
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(null, "list", "alpha", "schema",
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, true, true, 60000L);
    }

}
