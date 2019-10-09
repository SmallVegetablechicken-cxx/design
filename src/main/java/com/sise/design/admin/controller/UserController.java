package com.sise.design.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sise.design.admin.service.UserService;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 10:34
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping( value = "/admin/user")
@Controller("Admin_UserController")
public class UserController extends AdminBaseController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    UserService userService;

    @RequestMapping( value = "/user")
    public String coach(){
        return "admin/user/user";
    }

    @ResponseBody
    @RequestMapping( value = "/userData")
    public AjaxData userData( HttpServletRequest request ){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        String staffName = request.getParameter("name");
        if(staffName !=null ){
            wrapper.like("user_name",staffName);
        }
        ajaxData = getListUserByWapper( request , wrapper);
        return ajaxData;
    }

    @ResponseBody
    @RequestMapping( value = "/userDataUpdate")
    public AjaxData userDataUpdate( HttpServletRequest request ){
        ajaxData = userService.userDataUpdate(request);
        return ajaxData;
    }

}
