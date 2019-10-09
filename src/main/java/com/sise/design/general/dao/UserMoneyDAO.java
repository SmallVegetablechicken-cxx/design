package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.UserMoney;
import com.sise.design.general.mapper.UserMoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 13:07
 * @Descript: TODO
 * @Version: 1.0
 */

@Repository
public class UserMoneyDAO extends GeneralDAO{

    @Autowired
    private UserMoneyMapper userMoneyMapper;

    private static UserMoneyDAO userMoneyDAO;

    @PostConstruct
    public void init(){
        userMoneyDAO = this;
    }

    public UserMoneyDAO(){
        tableName = this.getClass().getName();
    }


    public int addUserMoney(UserMoney userMoney){
        try{
            return userMoneyDAO.userMoneyMapper.insert(userMoney);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }


    public List<UserMoney> selectUserMoneyList(Page<UserMoney> page, QueryWrapper<UserMoney> wrapper){
        try{
            return userMoneyDAO.userMoneyMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<UserMoney>();
        }
    }

    public List<Map<String,Object>> selectUserMoneyMap(Page<UserMoney> page, QueryWrapper<UserMoney> wrapper){
        try{
            return userMoneyDAO.userMoneyMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String,Object>>();
        }
    }


    public UserMoney selectUserMoneyByUid(int uid){
        try{
            return userMoneyDAO.userMoneyMapper.selectOne(new QueryWrapper<UserMoney>()
                    .eq("uid",uid));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserMoney();
        }
    }

    public double selectUserMoneySumByUid(int uid){
        try{
            return userMoneyDAO.userMoneyMapper.selectUserMoneySumByUid(uid);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    public UserMoney selectById(int id){
        try{
            return userMoneyDAO.userMoneyMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserMoney();
        }
    }

    public int selectCount(QueryWrapper<UserMoney> wrapper){
        try{
            return userMoneyDAO.userMoneyMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    public int deleteById(int id){
        try{
            return userMoneyDAO.userMoneyMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }
}
