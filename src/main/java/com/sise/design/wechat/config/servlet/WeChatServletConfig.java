package com.sise.design.wechat.config.servlet;

import com.sise.design.wechat.controller.WechatServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/27 18:46
 * @Descript: TODO
 * @Version: 1.0
 */

@Configuration
public class WeChatServletConfig {

    @Bean
    public ServletRegistrationBean<WechatServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new WechatServlet(),"/wechat");
    }
}
