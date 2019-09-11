package com.ywyt.springboot3.intecepter;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 老版本，已弃用，在jdk1.8之后弃用
 * jdk1.8之后直接 implements WebMvcConfigurer
 * 因为在jdk1.8以后，在interface中可以写默认的方法
 * @author xiejin
 * @date 2019/9/7 18:01
 */
//@Configuration
public class CustomOldWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
