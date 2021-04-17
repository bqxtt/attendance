package com.baobei.attendance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.
                addMapping("/**").
                allowedOrigins("*").
                allowCredentials(true).
                allowedMethods("*").
                allowedHeaders("*").
                maxAge(3600);
    }
}