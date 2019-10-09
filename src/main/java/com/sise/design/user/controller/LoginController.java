package com.sise.design.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 14:32
 * @Descript: TODO
 * @Version: 1.0
 */

@Controller("User_LoginController")
@RequestMapping(value = "/user")
public class LoginController extends UserBaseController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AjaxData ajaxData;

    @RequestMapping( value = "/index")
    public String index(Model model , HttpSession session){
        model.addAttribute("user",session.getAttribute("d_user_userName"));
        return "user/index";
    }

    @RequestMapping( value = "/test")
    public String test(Model model , HttpSession session){
        session.setAttribute("d_user_id" , 1);
        session.setAttribute("d_user_userId" , "test");
        session.setAttribute("d_user_userName" , "大屁孩");
        model.addAttribute("user","大屁孩");
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value = "/loginCheck")
    public String loginCheck( HttpServletRequest request){
        String userId       = request.getParameter("userId") ;
        String userPassword = request.getParameter("userPassword") ;
        if(userId == null || userPassword == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
            return ajaxData.toString();
        }
        User user = userDAO.loginCheck(userId ,userPassword);
        if(user == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
        }else {
            if(user.getState()==LOGIN_STOP){
                ajaxData.setStatus(AjaxDataMsg.STATUS_FAILURE);
                ajaxData.setMsg("该账户已停用");
                return ajaxData.toString();
            }
            HttpSession session=request.getSession();
            session.setAttribute("d_user_id" , user.getId());
            session.setAttribute("d_user_userId" , user.getUserId());
            session.setAttribute("d_user_userName" , user.getUserName());
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_SUCCESS);
            HashMap<String,Object> map = new HashMap<>(2);
            map.put("access_token", session.getId());
            ajaxData.setData(map);
        }
        return ajaxData.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/registerCheck")
    public String registerCheck( HttpServletRequest request){
        String userId       = request.getParameter("id") ;
        String userPassword = request.getParameter("password") ;
        String userPhone    = request.getParameter("phone") ;
        String userName     = request.getParameter("name") ;
        if(userId == null || userPassword == null || userPhone == null || userName ==null ){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            return ajaxData.toString();
        }
        if(userDAO.selectCount(new QueryWrapper<User>().eq("user_id",userId))>0){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("该账号已被其他人使用");
            return ajaxData.toString();
        }
        if(userDAO.selectCount(new QueryWrapper<User>().eq("user_phone",userId))>0){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("手机号码已被其他人使用,请更换其他手机号码");
            return ajaxData.toString();
        }
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserPhone(userPhone);
        user.setUserId(userId);
        if(userDAO.addUser(user)>0){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_SUCCESS);
            ajaxData.setMsg("注册成功");
        }else {
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("注册失败");
        }
        return ajaxData.toString();
    }
}
