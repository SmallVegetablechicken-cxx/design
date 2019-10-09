package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.UserCourse;
import com.sise.design.general.mapper.UserCourseMapper;
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
public class UserCourseDAO extends GeneralDAO{

    @Autowired
    private UserCourseMapper userCourseMapper;

    private static UserCourseDAO userCourseDAO;

    @PostConstruct
    public void init(){
        userCourseDAO = this;
    }

    public UserCourseDAO(){
        tableName = this.getClass().getName();
    }


    public int addUserCourse(UserCourse userCourse){
        try{
            return userCourseDAO.userCourseMapper.insert(userCourse);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }


    public List<UserCourse> selectUserCourseList(Page<UserCourse> page, QueryWrapper<UserCourse> wrapper){
        try{
            return userCourseDAO.userCourseMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<UserCourse>();
        }
    }

    public List<Map<String,Object>> selectUserCourseMap(Page<UserCourse> page, QueryWrapper<UserCourse> wrapper){
        try{
            return userCourseDAO.userCourseMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String,Object>>();
        }
    }


    public UserCourse selectUserCourseByUid( int uid ){
        try{
            return userCourseDAO.userCourseMapper.selectOne(new QueryWrapper<UserCourse>()
                    .eq("uid",uid));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserCourse();
        }
    }

    public UserCourse selectById( int id ){
        try{
            return userCourseDAO.userCourseMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new UserCourse();
        }
    }

    public int selectCount(QueryWrapper<UserCourse> wrapper){
        try{
            return userCourseDAO.userCourseMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    public int deleteById(int id){
        try{
            return userCourseDAO.userCourseMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }
}
