package com.sise.design.user.config.intercepter;

import com.sise.design.user.intercepter.UserSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 23:10
 * @Descript: TODO
 * @Version: 1.0
 */

@Configuration
public class UserSessionInterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        registry.addInterceptor(new UserSessionInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login.html")
                .excludePathPatterns("/user/loginCheck")
                .excludePathPatterns("/user/register.html")
                .excludePathPatterns("/user/registerCheck")
                .excludePathPatterns("/user/forget.html")
                .excludePathPatterns("/user/forgetCheck")
                .excludePathPatterns("/user/test");
    }
}
