package com.sise.design.coach.controller;

import com.sise.design.coach.service.CoachService;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
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

@Controller("Coach_CourseController")
@RequestMapping(value = "coach/course")
public class CourseController extends CoachBaseController {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    CoachService coachService;

    @RequestMapping( value = "/insert")
    public String staffInfo(Model model , HttpServletRequest request ){
        int id = (int) request.getSession().getAttribute("d_coach_id");
        Staff staff = staffDAO.selectById(id);
        model.addAttribute("staff", staff);
        return "coach/course/insert";
    }

    @ResponseBody
    @RequestMapping( value = "/insertData")
    public AjaxData updateUserInfo( HttpServletRequest request ){
        int id   = Integer.parseInt(request.getParameter("id"));
        return coachService.userDataUpdate(id ,"update" , request);
    }

}
