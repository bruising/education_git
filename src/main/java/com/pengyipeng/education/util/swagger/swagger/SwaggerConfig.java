package com.pengyipeng.education.util.swagger.swagger;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.pengyipeng.education.controller")).paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("教育-项目").contact(new Contact("碰一碰","https://www.baidu.com","xxx@qq.com")).version("1.1").description("碰一碰").build();
    }



}
