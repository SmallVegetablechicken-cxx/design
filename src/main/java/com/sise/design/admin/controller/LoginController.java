package com.sise.design.admin.controller;

import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/30 20:15
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping(value = "/admin")
@Controller("Admin_LoginController")
public class LoginController extends AdminBaseController {

    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private AjaxData ajaxData;

    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }
    @RequestMapping("/forget")
    public String forget(){
        return "admin/forget";
    }
    @RequestMapping("/register")
    public String register(){
        return "enter";
    }

    @ResponseBody
    @PostMapping("/loginCheck")
    public String loginCheck( HttpServletRequest request ){
        String userId       = request.getParameter("userId") ;
        String userPassword = request.getParameter("userPassword") ;
        if(userId == null || userPassword == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
            return ajaxData.toString();
        }
        Staff staff = staffDAO.loginCheck(userId ,userPassword);
        if(staff == null){
             ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
        }else {
            HttpSession session=request.getSession();
            session.setAttribute("d_admin_id" , staff.getId());
            session.setAttribute("d_admin_userId" , staff.getStaffId());
            session.setAttribute("d_admin_userName" , staff.getStaffName());
            session.setAttribute("d_admin_userPicture" , staff.getPicture());

            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_SUCCESS);
            HashMap map = new HashMap(2);
            map.put("access_token", session.getId());
            ajaxData.setData(map);
        }
        return ajaxData.toString();
    }

    @ResponseBody
    @GetMapping("/loginCheck")
    public String loginCheckGet(){
        ajaxData.setStatus(AjaxDataMsg.STATUS_OTHER);
        return ajaxData.toString();
    }

    @RequestMapping( value = "/index")
    public String index(Model model , HttpSession session){
        model.addAttribute("user",session.getAttribute("d_admin_userNickname"));
        return "admin/index";
    }

    @RequestMapping( value = "/test")
    public String code(Model model , HttpSession session){
        session.setAttribute("d_admin_id" ,1);
        session.setAttribute("d_admin_userId" ,"admin");
        session.setAttribute("d_admin_userName" ,"大屁孩");
        session.setAttribute("d_admin_userPicture" ,"admin");
        model.addAttribute("staff","大屁孩");
        return "admin/index";
    }

}
