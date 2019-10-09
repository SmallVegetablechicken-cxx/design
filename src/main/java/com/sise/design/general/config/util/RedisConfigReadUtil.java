package com.sise.design.general.config.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 11:40
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
@ConfigurationProperties(prefix="spring.redis")
public class RedisConfigReadUtil {

    private static int      database;
    private static String   host;
    private static int      port;
    private static String   password;
    private static int      maxActive;
    private static int      maxWait;
    private static int      maxIdle;
    private static int      minIdle;
    private static int     timeout;
    private static boolean testOnBorrow;

    public static int getDatabase() {
        return database;
    }

    @Value("${spring.redis.database}")
    public  void setDatabase(int database) {
        RedisConfigReadUtil.database = database;
    }

    public static String getHost() {
        return host;
    }

    @Value("${spring.redis.host}")
    public void setHost(String host) {
        RedisConfigReadUtil.host = host;
    }

    public static int getPort() {
        return port;
    }

    @Value("${spring.redis.port}")
    public void setPort(int port) {
        RedisConfigReadUtil.port = port;
    }

    public static String getPassword() {
        return password;
    }

    @Value("${spring.redis.password}")
    public void setPassword(String password) {
        RedisConfigReadUtil.password = password;
    }

    public static int getMaxActive() {
        return maxActive;
    }

    @Value("${spring.redis.lettuce.pool.max-active}")
    public  void setMaxActive(int maxActive) {
        RedisConfigReadUtil.maxActive = maxActive;
    }

    public static int getMaxWait() {
        return maxWait;
    }

    @Value("${spring.redis.lettuce.pool.max-wait}")
    public void setMaxWait(int maxWait) {
        RedisConfigReadUtil.maxWait = maxWait;
    }

    public static int getMaxIdle() {
        return maxIdle;
    }

    @Value("${spring.redis.lettuce.pool.max-idle}")
    public void setMaxIdle(int maxIdle) {
        RedisConfigReadUtil.maxIdle = maxIdle;
    }

    public static int getMinIdle() {
        return minIdle;
    }

    @Value("${spring.redis.lettuce.pool.min-idle}")
    public void setMinIdle(int minIdle) {
        RedisConfigReadUtil.minIdle = minIdle;
    }

    public static int getTimeout() {
        return timeout;
    }

    @Value("${spring.redis.jedis.pool.timeout}")
    public void setTimeout(int timeout) {
        RedisConfigReadUtil.timeout = timeout;
    }

    public static boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    @Value("${spring.redis.jedis.pool.TEST_ON_BORROW}")
    public void setTestOnBorrow(boolean testOnBorrow) {
        RedisConfigReadUtil.testOnBorrow = testOnBorrow;
    }
}
