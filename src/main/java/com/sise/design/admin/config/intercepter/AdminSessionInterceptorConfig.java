package com.sise.design.admin.config.intercepter;

import com.sise.design.admin.intercepter.AdminSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 23:10
 * @Descript: TODO
 * @Version: 1.0
 */

@Configuration
public class AdminSessionInterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        registry.addInterceptor(new AdminSessionInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/loginCheck")
                .excludePathPatterns("/admin/register")
                .excludePathPatterns("/admin/registerCheck")
                .excludePathPatterns("/admin/forget")
                .excludePathPatterns("/admin/forgetCheck")
                .excludePathPatterns("/admin/weixin/test")
                .excludePathPatterns("/admin/weixin/testValue")
                .excludePathPatterns("/admin/test");
    }
}
