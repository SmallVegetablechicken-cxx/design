package com.sise.design.user.controller;

import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import com.sise.design.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 14:31
 * @Descript: TODO
 * @Version: 1.0
 */

@Controller("User_UserController")
@RequestMapping(value = "user/user")
public class UserController extends UserBaseController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    UserService userService;

    @RequestMapping( value = "/info")
    public String staffInfo(Model model , HttpServletRequest request ){
        int id = (int) request.getSession().getAttribute("d_user_id");
        User user = userDAO.selectUserById( id );
        model.addAttribute("user", user);
        return "user/user/info";
    }

    @ResponseBody
    @RequestMapping( value = "/updateInfo")
    public AjaxData updateUserInfo( HttpServletRequest request ){
        int id   = Integer.parseInt(request.getParameter("id"));
        return userService.userDataUpdate(id ,"update" , request);
    }

}
