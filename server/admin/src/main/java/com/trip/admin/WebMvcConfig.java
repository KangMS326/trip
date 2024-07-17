package com.trip.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebMvc
@Log4j2
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("admin addCorsMappings()");
        
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
    
    // 정적 파일을 외부 디렉토리에 제공하기 위함
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("admin addResourceHandlers()");
        
        registry.addResourceHandler("/admin/**")
                .addResourceLocations("file:///c://admin/upload/");
    }
}