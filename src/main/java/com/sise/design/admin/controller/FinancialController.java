package com.sise.design.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.dao.UserMoneyDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserMoney;
import com.sise.design.user.controller.UserBaseController;
import com.sise.design.user.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/2 19:34
 * @Descript: TODO
 * @Version: 1.0
 */

@Controller("Admin_FinancialController")
@RequestMapping(value = "/admin/financial")
public class FinancialController extends UserBaseController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserMoneyDAO userMoneyDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    FinancialService financialService;

    @RequestMapping( value = "/bill" )
    public String bill(){
        return "admin/financial/bill";
    }

    @ResponseBody
    @RequestMapping( value = "/billData" )
    public AjaxData billData( HttpServletRequest request ){
        QueryWrapper<UserMoney> wrapper = new QueryWrapper<>();
        Page<UserMoney> pages = this.getPages(request);
        wrapper = getUserMoneyWapper(request,wrapper);
        List<Map<String,Object>> userMoneyData = userMoneyDAO.selectUserMoneyMap(pages,wrapper);
        List<Map<String,Object>> data = new LinkedList<>();
        for(Map<String,Object> map:userMoneyData){
            User user = userDAO.selectById((Integer) map.get("id"));
            map.put("name",user.getUserName());
            //long timestamp = Long.parseLong( (String) map.get("insert_time"));
            Timestamp timestamp = (Timestamp)map.get("insert_time");
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(timestamp.getTime()));
            map.put("insert_time",date);
            data.add(map);
        }
        ajaxData.setData(data);
        return ajaxData;
    }

}
