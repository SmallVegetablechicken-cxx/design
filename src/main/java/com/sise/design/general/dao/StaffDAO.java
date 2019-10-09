package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.mapper.StaffMapper;
import com.sise.design.general.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/27 10:32
 * @Descript: TODO
 * @Version: 1.0
 */

@Repository
public class StaffDAO extends GeneralDAO<Staff> implements IDAO<Staff>{

    @Autowired
    private StaffMapper staffMapper;

    private static StaffDAO staffDAO;

    public StaffDAO(){
        tableName = this.getClass().getName();
    }

    @PostConstruct
    public void init(){
        staffDAO = this;
    }

    public Staff loginCheck(String staffId, String staffPassword){
        try{
            return staffDAO.staffMapper.selectOne(new QueryWrapper<Staff>()
                    .eq("staff_id",staffId)
                    .eq("staff_password",staffPassword)
                    .or()
                    .eq("staff_phone",staffId)
                    .eq("staff_password",staffPassword));
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return null;
        }
    }

    public List<Staff> selectStaffList(Page<Staff> page, QueryWrapper<Staff> wrapper){
        try{
            return staffDAO.staffMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Staff>();
        }
    }

    public int selectCount(QueryWrapper<Staff> wrapper){
        try{
            return staffDAO.staffMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    @Override
    public Staff selectById(int id){
        try{
            return staffDAO.staffMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new Staff();
        }
    }

    public int updateStaff(Staff staff){
        try{
            return staffDAO.staffMapper.updateById(staff);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    public int addStaff(Staff staff){
        try{
            return staffDAO.staffMapper.insert(staff);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    @Override
    public int deleteById(int id){
        try{
            return staffDAO.staffMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    @Override
    public int update(Staff staff) {
        return 0;
    }
}