package com.xmbl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-15 -- 11:14
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableSwagger2
public class SwaggerApplication {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xmbl.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Infrastructure 基础服务器API 文档")
                //创建人
                .contact(new Contact("Noseparte", "https://github.com/noseparte/", "noseparte@aliyun.com"))
                //版本号
                .version("1.0")
                //描述
                .description("Infrastructure 基础服务器API 文档 Spring Boot 集成 Swagger2 构建RESTful API")
                .build();
    }

}
