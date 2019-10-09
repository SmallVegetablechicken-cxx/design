package com.sise.design.admin.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sise.design.admin.service.StaffService;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/19 16:59
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping( value = "/admin/staff")
@Controller("Admin_StaffController")
public class StaffController extends AdminBaseController {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    StaffService staffService;


//烂尾开始***************************************************************
    @RequestMapping( value = "/examine")
    public String examine(){
        return "admin/staff/examine";
    }

    @ResponseBody
    @RequestMapping( value = "/examineData")
    public AjaxData examineData( HttpServletRequest request ){
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("state",0 );
        ajaxData = getListStaffByWapper( request ,wrapper );
        return ajaxData;
    }

    @ResponseBody
    @RequestMapping( value = "/examineDataUpdate")
    public AjaxData examineDataUpdate( HttpServletRequest request ){
        int id    = Integer.parseInt(request.getParameter("id"));
        int state = Integer.parseInt(request.getParameter("state"));
        Staff staff = staffDAO.selectById(id);
        if(staff == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
        }else{
            staff.setState(state);
            int i = staffDAO.updateStaff(staff);
            if(i==0){
                ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_FAILURE);
            }else{
                ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_SUCCESS);
            }
        }
        return ajaxData;
    }
//烂尾结束***********************************************************************

    @RequestMapping( value = "/coach")
    public String coach(){
        return "admin/staff/coach";
    }

    @ResponseBody
    @RequestMapping( value = "/coachData")
    public AjaxData coachData( HttpServletRequest request ){
        QueryWrapper<Staff> wrapper=new QueryWrapper<>();
        String staffName = request.getParameter("name");
        if(staffName !=null ){
            wrapper.like("staff_name",staffName);
        }
        wrapper.eq("staff_type",3);
        ajaxData = getListStaffByWapper( request , wrapper);
        return ajaxData;
    }

    @ResponseBody
    @RequestMapping( value = "/coachDataUpdate")
    public AjaxData coachDataUpdate( HttpServletRequest request ){
        return staffService.staffDataUpdate(request);
    }

    @RequestMapping( value = "/staff")
    public String staff(){
        return "admin/staff/staff";
    }

    @ResponseBody
    @RequestMapping( value = "/staffData")
    public AjaxData staffData( HttpServletRequest request ){
        QueryWrapper<Staff> wrapper=new QueryWrapper<>();
        String staffName = request.getParameter("name");
        if( staffName !=null ){
            wrapper.like("staff_name",staffName);
        }
        wrapper.eq("state",1);
        wrapper.ge("staff_type",4);
        ajaxData = getListStaffByWapper( request , wrapper);
        return ajaxData;
    }

    @ResponseBody
    @RequestMapping( value = "/staffDataUpdate")
    public AjaxData staffDataUpdate( HttpServletRequest request ){
        return  staffService.staffDataUpdate(request);
    }
}
