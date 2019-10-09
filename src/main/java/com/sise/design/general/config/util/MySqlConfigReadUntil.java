package com.sise.design.general.config.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 11:16
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
@ConfigurationProperties(prefix="spring.datasource")
public class MySqlConfigReadUntil {

    private static String  url;
    private static String  username;
    private static String  password;
    private static String  driverClassName;
    private static int     initialSize;
    private static int     minIdle;
    private static int     maxActive;
    private static int     maxWait;
    private static int     timeBetweenEvictionRunsMillis;
    private static int     minEvictableIdleTimeMillis;
    private static String  validationQuery;
    private static boolean testWhileIdle;
    private static boolean testOnBorrow;
    private static boolean testOnReturn;
    private static boolean poolPreparedStatements;
    private static int     maxPoolPreparedStatementPerConnectionSize;

    public static String getUrl() {
        return url;
    }

    @Value("${spring.datasource.url}")
    public void setUrl(String url) {
        MySqlConfigReadUntil.url = url;
    }

    public static String getUsername() {
        return username;
    }

    @Value("${spring.datasource.username}")
    public void setUsername(String username) {
        MySqlConfigReadUntil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        MySqlConfigReadUntil.password = password;
    }

    public static String getDriverClassName() {
        return driverClassName;
    }

    @Value("${spring.datasource.driver-class-name}")
    public void setDriverClassName(String driverClassName) {
        MySqlConfigReadUntil.driverClassName = driverClassName;
    }

    public static int getInitialSize() {
        return initialSize;
    }

    @Value("${spring.datasource.initialSize}")
    public void setInitialSize(int initialSize) {
        MySqlConfigReadUntil.initialSize = initialSize;
    }

    public static int getMinIdle() {
        return minIdle;
    }

    @Value("${spring.datasource.minIdle}")
    public void setMinIdle(int minIdle) {
        MySqlConfigReadUntil.minIdle = minIdle;
    }

    public static int getMaxActive() {
        return maxActive;
    }

    @Value("${spring.datasource.maxActive}")
    public void setMaxActive(int maxActive) {
        MySqlConfigReadUntil.maxActive = maxActive;
    }

    public static int getMaxWait() {
        return maxWait;
    }

    @Value("${spring.datasource.maxWait}")
    public void setMaxWait(int maxWait) {
        MySqlConfigReadUntil.maxWait = maxWait;
    }

    public static int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        MySqlConfigReadUntil.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public static int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        MySqlConfigReadUntil.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public static String getValidationQuery() {
        return validationQuery;
    }

    @Value("${spring.datasource.validationQuery}")
    public void setValidationQuery(String validationQuery) {
        MySqlConfigReadUntil.validationQuery = validationQuery;
    }

    public static boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    @Value("${spring.datasource.testWhileIdle}")
    public void setTestWhileIdle(boolean testWhileIdle) {
        MySqlConfigReadUntil.testWhileIdle = testWhileIdle;
    }

    public static boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    @Value("${spring.datasource.testOnBorrow}")
    public void setTestOnBorrow(boolean testOnBorrow) {
        MySqlConfigReadUntil.testOnBorrow = testOnBorrow;
    }

    public static boolean isTestOnReturn() {
        return testOnReturn;
    }

    @Value("${spring.datasource.testOnReturn}")
    public void setTestOnReturn(boolean testOnReturn) {
        MySqlConfigReadUntil.testOnReturn = testOnReturn;
    }

    public static boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    @Value("${spring.datasource.poolPreparedStatements}")
    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        MySqlConfigReadUntil.poolPreparedStatements = poolPreparedStatements;
    }

    public static int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        MySqlConfigReadUntil.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }
}
