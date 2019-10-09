package com.sise.design.general.service;

import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/19 15:41
 * @Descript: TODO
 * @Version: 1.0
 */

@Service
public class GeneralService extends GeneralBaseService{

    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;

    public AjaxData loginCheck(HttpServletRequest request){
        String userId       = request.getParameter("userId") ;
        String userPassword = request.getParameter("userPassword") ;
        if(userId == null || userPassword == null){
            ajaxData.setStatus( AjaxDataMsg.STATUS_LOGIN_FAILURE );
            return ajaxData;
        }
        Staff staff = staffDAO.loginCheck(userId ,userPassword);
        if(staff == null){
            ajaxData.setStatus( AjaxDataMsg.STATUS_LOGIN_FAILURE );
        }else {
            HttpSession session=request.getSession();
            if(staff.getStaffType()<=1){
                session.setAttribute("d_admin_userId" , staff.getStaffId());
                session.setAttribute("d_admin_userName" , staff.getStaffName());
                session.setAttribute("d_admin_userPicture" , staff.getPicture());
            }
            else if(staff.getStaffType()==2){
                session.setAttribute("d_coach_userId" , staff.getStaffId());
                session.setAttribute("d_coach_userName" , staff.getStaffName());
                session.setAttribute("d_coach_userPicture" , staff.getPicture());
            }
            else{
                session.setAttribute("d_staff_userId" , staff.getStaffId());
                session.setAttribute("d_staff_userName" , staff.getStaffName());
                session.setAttribute("d_staff_userPicture" , staff.getPicture());
            }
            ajaxData.setStatus( AjaxDataMsg.STATUS_LOGIN_SUCCESS );
            HashMap map = new HashMap(2);
            map.put("access_token", session.getId());
            map.put("staffType", staffType.get(staff.getStaffType()));
            ajaxData.setData(map);
        }
        return ajaxData;
    }
}
