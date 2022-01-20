package com.demo.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Swagger2配置类
 * @Author WangJunLiang
 * @Date 2022/1/19 15:45
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Demo接口文档")
                .description("Demo接口文档")
                .contact(new Contact("Wangjunliang","http://localhost:8080/doc.html","2222@22.com"))
                .version("1.9")
                .build();
    }

    private List<SecurityScheme> securitySchemes(){
        //设置请求头信息
        List<SecurityScheme> result=new ArrayList<>();
        ApiKey apiKey=new ApiKey("Authorization","Authorization","Header");
        result.add((SecurityScheme)apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts(){
        //设置需要登录认证的路径
        List<SecurityContext> result=new ArrayList<>();
        result.add(getContextByPath("/hello/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String s){

        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(s))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result=new ArrayList<>();
        AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEverything");
        AuthorizationScope []authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }
}