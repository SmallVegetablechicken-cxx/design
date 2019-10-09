package com.sise.design.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.dao.UserMoneyDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserMoney;
import com.sise.design.general.util.content.AjaxDataMsg;
import com.sise.design.user.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/2 19:34
 * @Descript: TODO
 * @Version: 1.0
 */

@Controller("User_FinancialController")
@RequestMapping(value = "/user/financial")
public class FinancialController extends UserBaseController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserMoneyDAO userMoneyDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    FinancialService financialService;

    @ResponseBody
    @RequestMapping( value = "/recharge" )
    public AjaxData recharge( HttpServletRequest request , HttpSession session){
        return financialService.recharge(request ,session);
    }

    @RequestMapping( value = "/bill" )
    public String bill(){
        return "user/financial/bill";
    }

    @ResponseBody
    @RequestMapping( value = "/billData" )
    public AjaxData billData( HttpServletRequest request ,HttpSession session){
        int id = (int) session.getAttribute("d_user_id");
        QueryWrapper<UserMoney> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        ajaxData = getListUserMoneyByWapper(request ,wrapper);
        return ajaxData;
    }

}
