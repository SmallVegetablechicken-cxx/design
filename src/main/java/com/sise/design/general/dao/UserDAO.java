package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserWages;
import com.sise.design.general.mapper.UserMapper;
import com.sise.design.general.util.content.DateTime;
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
public class UserDAO extends GeneralDAO implements IDAO<User>{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserWagesDAO userWagesDAO;

    private static UserDAO userDAO;

    @PostConstruct
    public void init(){
        userDAO = this;
    }

    public UserDAO(){
        tableName = this.getClass().getName();
    }

    public User loginCheck(String userId, String userPassword){
        try{
            return userDAO.userMapper.selectOne(new QueryWrapper<User>()
                    .eq("user_id",userId)
                    .eq("user_password",userPassword)
                    .or()
                    .eq("user_phone",userId)
                    .eq("user_password",userPassword));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return null;
        }
    }


    public int addUser(User user){
        try{
            return userDAO.userMapper.insert(user);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }

    public List<Map<String, Object>> selectUserListMap(Page<User> page, QueryWrapper<User> wrapper){
        try{
            return userDAO.userMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String, Object>>();
        }
    }

    public List<User> selectUserList(Page<User> page, QueryWrapper<User> wrapper){
        try{
            return userDAO.userMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<User>();
        }
    }

    public Map<Integer,User> selectUserMap( QueryWrapper<User> wrapper ){
        HashMap<Integer,User> map = new HashMap<>(10);
        try{
            List<User> data = userDAO.userMapper.selectList( wrapper );
            for(User user:data){
                map.put(user.getId(),user);
            }
            return map;
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new HashMap<>(0);
        }
    }

    public User selectUserByUserId(String staffId){
        try{
            return userDAO.userMapper.selectOne(new QueryWrapper<User>()
                    .eq("staff_id",staffId)
                    .le("staff_type",2));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new User();
        }
    }

    @Override
    public User selectById( int id ){
        try{
            return userDAO.userMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new User();
        }
    }

    public User selectUserById( int id ){
        try{
            User user = userDAO.userMapper.selectById(id);
            UserWages userWages = userWagesDAO.selectUserWagesByUid(user.getId());
            if(userWages.getWages()!=0 && !DateTime.compareDateTime(userWages.getWagesTime())){
                userWages.setWages(0);
                userWages.setWagesTime(null);
                userWagesDAO.updateUserWages(userWages);
            }
            user.setUserWages(userWages);
            return user;
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new User();
        }
    }

    public int selectCount(QueryWrapper<User> wrapper){
        try{
            return userDAO.userMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    @Override
    public int deleteById(int id){
        try{
            return userDAO.userMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    @Override
    public int update(User user) {
        return 0;
    }

    public int updateUser(User user){
        try{
            return userDAO.userMapper.updateById(user);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    public int updateUserStateByid(int id,int state){
        try{
            User user = selectById(id);
            user.setState(state);
            return userDAO.userMapper.updateById(user);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

}
