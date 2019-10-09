package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.UserWages;
import com.sise.design.general.mapper.UserWagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 13:07
 * @Descript: TODO
 * @Version: 1.0
 */

@Repository
public class UserWagesDAO extends GeneralDAO{

    @Autowired
    private UserWagesMapper userWagesMapper;

    private static UserWagesDAO userWagesDAO;

    @PostConstruct
    public void init(){
        userWagesDAO = this;
    }

    public UserWagesDAO(){
        tableName = this.getClass().getName();
    }


    public int addUserWages(UserWages userWages){
        try{
            return userWagesDAO.userWagesMapper.insert(userWages);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }


    public List<UserWages> selectUserWagesList(Page<UserWages> page, QueryWrapper<UserWages> wrapper){
        try{
            return userWagesDAO.userWagesMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<UserWages>();
        }
    }

    public List<Map<String,Object>> selectUserWagesMap(Page<UserWages> page, QueryWrapper<UserWages> wrapper){
        try{
            return userWagesDAO.userWagesMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String,Object>>();
        }
    }

    public UserWages selectUserWagesByUid(int uid){
        try{
            UserWages userWages = userWagesDAO.userWagesMapper.selectOne(new QueryWrapper<UserWages>()
                                    .eq("uid",uid));
            if(userWages == null) {
                return new UserWages();
            }
            return userWages;
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserWages();
        }
    }

    public UserWages selectById(int id){
        try{
            return userWagesDAO.userWagesMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserWages();
        }
    }

    public int selectCount(QueryWrapper<UserWages> wrapper){
        try{
            return userWagesDAO.userWagesMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    public int updateUserWages(UserWages userWages){
        try{
            return userWagesDAO.userWagesMapper.updateById(userWages);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    public int deleteById(int id){
        try{
            return userWagesDAO.userWagesMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }
}
