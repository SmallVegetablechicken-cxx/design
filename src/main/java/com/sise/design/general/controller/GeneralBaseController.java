package com.sise.design.general.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.dao.UserMoneyDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.UserMoney;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/18 19:12
 * @Descript: TODO
 * @Version: 1.0
 */

public class GeneralBaseController {

    @Autowired
    UserMoneyDAO userMoneyDAO;
    @Autowired
    AjaxData ajaxData;

    protected static String DEL        = "del";
    protected static String INSERT     = "insert";
    protected static String UPDATE     = "update";
    protected static int    LOGIN_STOP = -1;

    protected Page getPages(HttpServletRequest request ){
        int page  = request.getParameter("page")  == null ? 0 :Integer.parseInt(request.getParameter("page"));
        int limit = request.getParameter("limit") == null ? 10:Integer.parseInt(request.getParameter("limit"));
        return new Page<>(page,limit);
    }

    protected <T>Page<T> getPage( HttpServletRequest request ,T t){
        int page  = request.getParameter("page")==null  ? 0:Integer.parseInt(request.getParameter("page"));
        int limit = request.getParameter("limit")==null ? 10:Integer.parseInt(request.getParameter("limit"));
        return new Page<T>(page,limit);
    }

    protected String jsonData(int num ,Object data){
        return "{" +
                " \n\"code\": 0" +
                " \n,\"msg\": \"获取数据\"" +
                " \n,\"count\": " + num +
                " \n,\"data\": " + JSON.toJSONString(data)+
                "\n}  ";
    }

    protected AjaxData getListUserMoneyByWapper( HttpServletRequest request , QueryWrapper<UserMoney> wrapper){
        wrapper =this.getUserMoneyWapper(request,wrapper);
        Page<UserMoney> pages = this.getPages(request);
        List<UserMoney> list = userMoneyDAO.selectUserMoneyList(pages,wrapper);
        int count = userMoneyDAO.selectCount(wrapper);
        ajaxData.setData(list);
        ajaxData.setCount(count);
        return ajaxData;
    }

    protected QueryWrapper<UserMoney> getUserMoneyWapper( HttpServletRequest request ,QueryWrapper<UserMoney> wrapper ){
        String insertTime1 = request.getParameter("insertTime1");
        String insertTime2 = request.getParameter("insertTime2");
        String type = request.getParameter("type");
        if( insertTime1 != null ){
            wrapper.ge("insert_time",insertTime1);
        }
        if( insertTime2 != null ){
            wrapper.le("insert_time",insertTime2);
        }
        if( type !=null ){
            wrapper.eq("type",type);
        }
        return wrapper;
    }
}
