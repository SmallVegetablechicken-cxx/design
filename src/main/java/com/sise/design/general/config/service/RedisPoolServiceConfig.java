package com.sise.design.general.config.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author:    Chen xuexin
 * @Time:      2019/7/17 20:31
 * @Descript:  TODO
 * @Version:   1.0
 */

@Service(value = "RedisPoolService")
public class RedisPoolServiceConfig {

    private static JedisPool jedis = null;
    private static final Logger logger = LoggerFactory.getLogger(RedisPoolServiceConfig.class);

    /*
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(50);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(5000);
            config.setTestOnBorrow(true);
            //如果你的redis设置了密码，在创建时添加AUTH参数
            jedis = new JedisPool(config, "127.0.0.1", 6379, 10000);
            logger.info("Redis连接池初始化成功");
            //System.out.println(RedisConfigReadUtil.getHost());
        } catch (Exception e) {
            logger.info("Redis连接池初始化失败");
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            if (jedis != null) {
                return  jedis.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * param jedis
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
