package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description SpringMVC配置类
 * @Author WangJunLiang
 * @Date 2022/2/7 17:47
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    /**
     * 重写addCorsMappings解决跨域问题
     */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}