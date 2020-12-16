package com.bsm.config;

import com.bsm.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Configuration
public class SessionConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        List<String> noAuthUriList = new ArrayList<String>(Arrays.asList("/login", "/register", "/captcha", "/checkCaptcha", "/webjars/**"));
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns(noAuthUriList);
    }
}
