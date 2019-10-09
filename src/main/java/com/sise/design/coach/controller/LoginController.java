package com.sise.design.coach.controller;

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

@Controller("Coach_LoginController")
@RequestMapping(value = "/coach")
public class LoginController extends CoachBaseController {

    @Autowired
    UserDAO coachDAO;
    @Autowired
    AjaxData ajaxData;

    @RequestMapping( value = "/index")
    public String index(Model model , HttpSession session){
        model.addAttribute("coach",session.getAttribute("d_coach_coachName"));
        return "coach/index";
    }

    @RequestMapping( value = "/test")
    public String test(Model model , HttpSession session){
        session.setAttribute("d_coach_id" , 1);
        session.setAttribute("d_coach_coachId" , "test");
        session.setAttribute("d_coach_coachName" , "大屁孩");
        model.addAttribute("coach","大屁孩");
        return "coach/index";
    }

    @ResponseBody
    @RequestMapping(value = "/loginCheck")
    public String loginCheck( HttpServletRequest request){
        String coachId       = request.getParameter("coachId") ;
        String coachPassword = request.getParameter("coachPassword") ;
        if(coachId == null || coachPassword == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
            return ajaxData.toString();
        }
        User coach = coachDAO.loginCheck(coachId ,coachPassword);
        if(coach == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_FAILURE);
        }else {
            if(coach.getState()==LOGIN_STOP){
                ajaxData.setStatus(AjaxDataMsg.STATUS_FAILURE);
                ajaxData.setMsg("该账户已停用");
                return ajaxData.toString();
            }
            HttpSession session=request.getSession();
            session.setAttribute("d_coach_id" , coach.getId());
            session.setAttribute("d_coach_coachId" , coach.getUserId());
            session.setAttribute("d_coach_coachName" , coach.getUserName());
            ajaxData.setStatus(AjaxDataMsg.STATUS_LOGIN_SUCCESS);
            HashMap<String,Object> map = new HashMap<>(2);
            map.put("access_token", session.getId());
            ajaxData.setData(map);
        }
        return ajaxData.toString();
    }

}
