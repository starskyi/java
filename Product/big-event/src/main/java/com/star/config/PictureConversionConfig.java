package com.star.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PictureConversionConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        System.out.println(System.getProperty("user.dir"));
        registry.addResourceHandler("/resources/**").addResourceLocations("file:/D:/file/");
    }
}
