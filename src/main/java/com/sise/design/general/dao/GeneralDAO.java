package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sise.design.general.mapper.GeneralMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Chen xuexin
 * @Time: 2019/8/28 15:05
 * @Descript: TODO
 * @Version: 1.0
 */

public class GeneralDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(GeneralDAO.class);

    protected String tableName;

    @Autowired
    GeneralMapper<T> generalMapper;

    public T loginCheck2(String userId, String userPassword){
        try{
            return generalMapper
                    .selectOne(new QueryWrapper<T>()
                    .eq("staff_id",userId)
                    .eq("staff_password",userPassword)
                    .or()
                    .eq("staff_phone",userId)
                    .eq("staff_password",userPassword));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return null;
        }
    }

    protected void exceptionMessage(Exception e ,String where){
        logger.error("数据库查询语句失败！！！   位置："+where);
        System.out.println("-------------------------start print exception message--------------------------------");
        if (e.getMessage() == null) {
            e.printStackTrace();
        } else {
            System.out.println(e.getMessage());
        }
        System.out.println("---------------------------end print exception  message--------------------------------");
    }
}
