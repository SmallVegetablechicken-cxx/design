package com.sise.design.general.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.entity.Parameter;
import com.sise.design.general.mapper.ParameterMapper;
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
public class ParameterDAO extends GeneralDAO{

    @Autowired
    private ParameterMapper parameterMapper;

    private static ParameterDAO parameterDAO;

    @PostConstruct
    public void init(){
        parameterDAO = this;
    }

    public ParameterDAO(){
        tableName = this.getClass().getName();
    }


    public int addParameter(Parameter parameter){
        try{
            return parameterDAO.parameterMapper.insert(parameter);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return -1;
        }
    }


    public List<Parameter> selectParameterList(Page<Parameter> page, QueryWrapper<Parameter> wrapper){
        try{
            return parameterDAO.parameterMapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Parameter>();
        }
    }

    public List<Map<String,Object>> selectParameterMap(Page<Parameter> page, QueryWrapper<Parameter> wrapper){
        try{
            return parameterDAO.parameterMapper.selectMapsPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<Map<String,Object>>();
        }
    }

    public Parameter selectById(int id){
        try{
            return parameterDAO.parameterMapper.selectById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new Parameter();
        }
    }

    public int selectCount(QueryWrapper<Parameter> wrapper){
        try{
            return parameterDAO.parameterMapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    public int updateParameter(Parameter parameter){
        try{
            return parameterDAO.parameterMapper.updateById(parameter);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }


    public int deleteById(int id){
        try{
            return parameterDAO.parameterMapper.deleteById(id);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }
}
