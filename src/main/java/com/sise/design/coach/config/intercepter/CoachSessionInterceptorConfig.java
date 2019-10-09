package com.sise.design.coach.config.intercepter;

import com.sise.design.coach.intercepter.CoachSessionInterceptor;
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
public class CoachSessionInterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        registry.addInterceptor(new CoachSessionInterceptor())
                .addPathPatterns("/coach/**")
                .excludePathPatterns("/coach/login.html")
                .excludePathPatterns("/coach/loginCheck")
                .excludePathPatterns("/coach/register.html")
                .excludePathPatterns("/coach/registerCheck")
                .excludePathPatterns("/coach/forget.html")
                .excludePathPatterns("/coach/forgetCheck")
                .excludePathPatterns("/coach/test");
    }
}
