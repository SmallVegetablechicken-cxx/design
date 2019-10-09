package com.sise.design.general.config.service;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 12:37
 * @Descript: 配置MySQL连接池
 * @Version: 2.0
 */

@Configuration
public class MySqlPoolServerConfig {

    @Autowired
    private Environment env;
    private static final Logger logger = LoggerFactory.getLogger(MySqlPoolServerConfig.class);

    @Bean
    public DataSource datasource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.datasource.url"));
        datasource.setUsername(env.getProperty("spring.datasource.username"));
        datasource.setPassword(env.getProperty("spring.datasource.password"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        datasource.setInitialSize(Integer.parseInt(env.getProperty("spring.datasource.initialSize")));
        datasource.setMinIdle(Integer.parseInt(env.getProperty("spring.datasource.minIdle")));
        datasource.setMaxActive(Integer.parseInt(env.getProperty("spring.datasource.maxActive")));
        datasource.setMaxWait(Long.parseLong(env.getProperty("spring.datasource.maxWait")));
        datasource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
        datasource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("spring.datasource.testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("spring.datasource.testOnBorrow")));
        datasource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("spring.datasource.testOnReturn")));
        datasource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("spring.datasource.poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize")));
        datasource.setRemoveAbandoned(Boolean.parseBoolean(env.getProperty("spring.datasource.removeAbandoned")));
        datasource.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("spring.datasource.removeAbandonedTimeout")));
        datasource.setLogAbandoned(Boolean.parseBoolean(env.getProperty("spring.datasource.logAbandoned")));
        try {
            datasource.setFilters(env.getProperty("spring.datasource.filters"));
            logger.info("MySQL线程池初始化成功");
        } catch (SQLException e) {
            logger.info("MySQL线程池初始化失败");
            e.printStackTrace();
        }
        return datasource;
    }
}
