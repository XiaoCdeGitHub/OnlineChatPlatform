package com.example.demo.config;

import ch.qos.logback.classic.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@Configuration
//public class BaseInterceptor extends WebMvcConfigurationSupport {
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/image/**").addResourceLocations("file:" + System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image\\");
//        super.addResourceHandlers(registry);
//    }
//
//}

@Configuration
public class BaseInterceptor extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imagePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "image").toFile().getAbsolutePath();

        registry.addResourceHandler("/image/**")
                .addResourceLocations(imagePath);
        super.addResourceHandlers(registry);
    }
}


