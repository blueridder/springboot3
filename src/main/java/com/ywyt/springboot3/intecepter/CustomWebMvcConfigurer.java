package com.ywyt.springboot3.intecepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiejin
 * @date 2019/9/7 18:01
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntecepter())
                .addPathPatterns("/start/*/**")
                .excludePathPatterns("/start/getEmp");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
