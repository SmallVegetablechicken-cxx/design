package com.sise.design.general.config.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

/**
 * @author:    Chen xuexin
 * @Time:     2019/7/22 14:50
 * @Descript: 阿里云MySQL线程池Servlet
 * @Version: 1.0
 */

@Configuration
public class DruidServletConfig extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DruidServletConfig.class);

    @Bean
    public ServletRegistrationBean<StatViewServlet> druid() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
//        reg.addInitParameter("loginUsername", "admin");
//        reg.addInitParameter("loginPassword","admin");
        reg.addInitParameter("logSlowSql", "true");
        logger.info("Druid页面初始化成功");
        return reg;
    }
}
