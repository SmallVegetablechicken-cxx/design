//package com.sise.design.general.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 11:42
 * @Descript: TODO
 * @Version: 1.0
 */

//@Service(value = "RedisService")
//public class RedisServiceImpl {
//
//    private static StringRedisTemplate stringRedisTemplate ;
//    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
//
//    static {
//        try {
//            stringRedisTemplate = new StringRedisTemplate();
//            logger.info("静态Redis服务初始化成功");
//        }catch (Exception e){
//            logger.info("静态Redis服务初始化失败");
//            e.printStackTrace();
//        }
//    }
//
//    public static StringRedisTemplate getRedisConn(){
//        return stringRedisTemplate;
//    }
//}
