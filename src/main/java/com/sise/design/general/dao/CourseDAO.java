package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.Course;
import com.sise.design.general.mapper.CourseMapper;
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
public class CourseDAO extends GeneralDAO implements IDAO<Course>{

    @Autowired
    private CourseMapper courseMapper;

    private static CourseDAO courseDAO;

    @PostConstruct
    public void init(){
        courseDAO = this;
    }

    public CourseDAO(){
        tableName = this.getClass().getName();
    }

    public int addCourse(Course course){
        try{
            return courseDAO.courseMapper.insert(course);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }

    public List<Map<String, Object>> selectCourseListMap(Page<Course> page, QueryWrapper<Course> wrapper){
        try{
            return courseDAO.courseMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String, Object>>();
        }
    }

    public List<Course> selectCourseList(Page<Course> page, QueryWrapper<Course> wrapper){
        try{
            return courseDAO.courseMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Course>();
        }
    }

    public Map<Integer,Course> selectCourseMap( QueryWrapper<Course> wrapper ){
        HashMap<Integer,Course> map = new HashMap<>(10);
        try{
            List<Course> data = courseDAO.courseMapper.selectList( wrapper );
            for(Course course:data){
                map.put(course.getId(),course);
            }
            return map;
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new HashMap<>(0);
        }
    }

    @Override
    public Course selectById( int id ){
        try{
            return courseDAO.courseMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new Course();
        }
    }

    public int selectCount(QueryWrapper<Course> wrapper){
        try{
            return courseDAO.courseMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    @Override
    public int deleteById(int id){
        try{
            return courseDAO.courseMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    @Override
    public int update(Course course) {
        return 0;
    }

    public int updateCourse(Course course){
        try{
            return courseDAO.courseMapper.updateById(course);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

}
