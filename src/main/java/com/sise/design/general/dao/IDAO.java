package com.sise.design.general.dao;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 20:01
 * @Descript: TODO
 * @Version: 1.0
 */

public interface IDAO<T> {

    public <t> t selectById(int id);
    public int deleteById(int id);
    public int update(T t);
}
