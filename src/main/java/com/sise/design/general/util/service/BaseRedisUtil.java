package com.sise.design.general.util.service;

public interface BaseRedisUtil {
    /**
     * 缓存取值
     * @param key String
     * @return String
     */
    public String get(String key);
    /**
     * 存缓存
     * @param key String
     * @param value String
     */
    public void set(String key, String value);
    /**
     * 存缓存
     * @param key String
     * @param value String
     * @param time int
     */
    public void set(String key, String value, int time);
    /**
     * 缓存删除
     * @param key String
     */
    public void delete(String key);
}
