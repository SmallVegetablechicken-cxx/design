//package com.sise.design.general.service;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.mysql.cj.exceptions.DataTruncationException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 12:37
 * @Descript: 配置MySQL
 * @Version: 2.0
 */
//@Service(value = "MySqlServer")
//public class MySqlServerImpl {
//
//    private static JdbcTemplate jdbcTemplate;
//    private static final Logger logger = LoggerFactory.getLogger(MySqlServerImpl.class);
//
//    static {
//        try{
//            DruidDataSource datasource = new DruidDataSource();
//            datasource.setUrl("jdbc:mysql://127.0.0.1:3306/php?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
//            datasource.setUsername("root");
//            datasource.setPassword("1234");
//            datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//            jdbcTemplate = new JdbcTemplate(datasource);
//            logger.info("静态MySQL服务初始化成功");
//        }catch (DataTruncationException e){
//            logger.info("静态MySQL服务初始化失败");
//            e.printStackTrace();
//        }
//
//    }
//
//    public static JdbcTemplate getJdbcTemplate(){
//        return jdbcTemplate;
//    }
//}
