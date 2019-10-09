package com.sise.design.wechat.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.wechat.mapper.WechatStrMapper;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class WechatStrDAO extends WechatBaseDAO {

    @Autowired
    private WechatStrMapper mapper;

    private static WechatStrDAO weChatStrDAO;

    @PostConstruct
    public void init(){
        weChatStrDAO = this;
    }

    public WechatStrDAO(){
        tableName = this.getClass().getName();
    }

    public List<WechatStr> getStrList(Page<WechatStr> page, QueryWrapper<WechatStr> wrapper){
        try{
            return weChatStrDAO.mapper.selectPage(page,wrapper).getRecords();
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return new ArrayList<>();
        }
    }

    public int getStrNum(QueryWrapper<WechatStr> wrapper){
        try{
            return weChatStrDAO.mapper.selectCount(wrapper);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }

    public int insertStr(String user, String msg, int msgAction, int msgType){
        try{
            WechatStr str =new WechatStr(user, msg, msgAction, msgType);
            return weChatStrDAO.mapper.insert(str);
        }catch (Exception e){
            exceptionMessage(e ,tableName);
            return 0;
        }
    }
}