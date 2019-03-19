package com.swkang.springboot.springboothello.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomerWebMvcConfiguer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**"); //拦截的资源
        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
                //.excludePathPatterns("/api2/xx/**");  不进行拦截的资源
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
