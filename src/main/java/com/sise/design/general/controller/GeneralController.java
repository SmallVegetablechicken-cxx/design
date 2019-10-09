package com.sise.design.general.controller;

import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.service.GeneralService;
import com.sise.design.general.util.content.AjaxDataMsg;
import com.sise.design.general.util.service.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 10:34
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping( value = "/general" )
@Controller("General_GeneralController")
public class GeneralController extends GeneralBaseController{

    @Autowired
    RedisPoolUtil redis;
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private AjaxData ajaxData;
    @Autowired
    private GeneralService generalServices;

    @RequestMapping( value = "/test")
    public String code(Model model , HttpSession session){
        session.setAttribute("d_admin_id" ,1);
        session.setAttribute("d_admin_userid" ,"admin");
        session.setAttribute("d_admin_userName" ,"大屁孩");
        session.setAttribute("d_admin_userPicture" ,"admin");
        model.addAttribute("staff","大屁孩");
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "general/login";
    }

    @RequestMapping("/forget")
    public String forget(){
        return "general/forget";
    }

    @RequestMapping("/enter")
    public String enter(){
        return "general/enter";
    }

    @ResponseBody
    @RequestMapping("/loginCheck")
    public AjaxData login( HttpServletRequest request ){
        return generalServices.loginCheck(request);
    }

    @ResponseBody
    @RequestMapping("/registerInput")
    public String registerInput( HttpServletRequest request ){

        String userName = request.getParameter("name") ;
        String userPassword = request.getParameter("password") ;
        String userNo = request.getParameter("no") ;
        int    userSex = Integer.parseInt(request.getParameter("sex"))  ;
        String userPhone = request.getParameter("phone") ;
        String userWechat = request.getParameter("wechat") ;
        String userBirthday = request.getParameter("date") ;
        String userId = request.getParameter("id") ;
        String agreement = request.getParameter("agreement") ;
        int    type = Integer.parseInt(request.getParameter("type")) ;
        Staff staff = new Staff();
        staff.setStaffBirthday(userBirthday);
        staff.setStaffName(userName);
        staff.setStaffId(userId);
        staff.setStaffPassword(userPassword);
        staff.setStaffNo(userNo);
        staff.setStaffSex(userSex);
        staff.setStaffPhone(userPhone);
        staff.setStaffWechat(userWechat);
        staff.setStaffType(type);
        if(staffDAO.addStaff(staff)==1){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_SUCCESS);
        }else{
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
        }
        return ajaxData.toString();
    }


}
