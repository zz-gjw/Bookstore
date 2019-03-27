package com.zz.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2  //启用Swagger
public class SwaggerConfig {
    public ApiInfo createApi(){
        return new ApiInfoBuilder().title("个人项目项目接口文档").
                description("模拟真实的企业开发环境").
                contact(new Contact("zz_gjw","http://1000phone.com","zz_gjw@189.com")).build();
    }
    @Bean  //等价于 <bean>标签
    public Docket createDoc(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApi()).select().
                apis(RequestHandlerSelectors.basePackage("com.zz.bookstore.controller")).build();
    }
}
