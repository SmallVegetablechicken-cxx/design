package com.sise.design.general.config.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 14:51
 * @Descript: 阿里云MySQL线程池过滤器，过滤前端样式内容
 * @Version: 1.0
 */

@Configuration
public class DruidFilterConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidFilterConfig.class);

    @Bean
    public FilterRegistrationBean druidFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        logger.info("Druid过滤器初始化成功");
        return filterRegistrationBean;
    }
}
