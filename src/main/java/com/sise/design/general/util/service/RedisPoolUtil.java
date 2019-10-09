package com.sise.design.general.util.service;

import com.sise.design.general.config.service.RedisPoolServiceConfig;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 * @author:   Chen xuexin
 * @Time:      2019/7/17 21:10
 * @Descript:  TODO
 * @Version:   1.0
 */

@Repository
public class RedisPoolUtil {

    public Jedis jedis ;

    public RedisPoolUtil(){
        jedis= RedisPoolServiceConfig.getJedis();
    }

    public void set(String key, String value) {
        jedis.set(key, value );
    }

    public void set(String key, String value ,int time) {
        jedis.setex(key ,time ,value);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public void delete(String key) {
        jedis.del(key);
    }

    public void close(){
        RedisPoolServiceConfig.close(jedis);
    }

    public Jedis getJedis(){
        return jedis;
    }
}
