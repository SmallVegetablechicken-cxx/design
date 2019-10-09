//package com.sise.design.general.util.service;
//
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author:   Chen xuexin
// * @Time:     2019/7/17 20:31
// * @Descript: TODO
// * @Version:  1.0
// */
//
//@Component
//public class RedisUtil {
//
//    private static StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//
//    public static void set(String key, String value) {
//        stringRedisTemplate.opsForValue().set(key, value);
//    }
//
//    public static void set(String key, String value, int time) {
//        stringRedisTemplate.opsForValue().set(key, value, time*1000);
//    }
//
//    public static String get(String key) {
//        return stringRedisTemplate.opsForValue().get(key);
//    }
//
//    public static void delete(String key) {
//        stringRedisTemplate.delete(key);
//    }
//}
