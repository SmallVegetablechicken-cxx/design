package com.sise.design.general.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sise.design.general.dao.IDAO;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.dao.UserMoneyDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserMoney;
import com.sise.design.general.mapper.StaffMapper;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 19:31
 * @Descript: TODO
 * @Version: 1.0
 */

public class GeneralBaseService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    UserMoneyDAO userMoneyDAO;

    protected static String DEL = "del";
    protected static String INSERT = "insert";
    protected static String UPDATE = "update";
    protected static String STOP = "stop";
    protected static String START = "start";


    protected static HashMap<Integer , String> staffType = new HashMap<>(9);

    static {
        staffType.put(0,"admin");
        staffType.put(1,"admin");
        staffType.put(2,"");
        staffType.put(3,"coach");
        staffType.put(4,"staff");
        staffType.put(5,"staff");
        staffType.put(6,"staff");
        staffType.put(7,"staff");
    }

    public AjaxData userDataUpdate(HttpServletRequest request){
        int id   = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        return userDataUpdate(id,type,request);
    }

    public AjaxData userDataUpdate(int id,String type, HttpServletRequest request){
        int result;

        if(DEL.equals(type)){
            result = userDAO.deleteById(id);
            if(result==0){
                ajaxData.setStatus(AjaxDataMsg.STATUS_DEL_FAILURE);
            }else{
                ajaxData.setStatus(AjaxDataMsg.STATUS_DEL_SUCCESS);
            }
        }
        else if (UPDATE.equals(type)){
            User user = userDAO.selectById(id);
            if(user == null){
                ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            }
            else{
                String userName   = request.getParameter("userName");
                int    userSex    = Integer.parseInt(request.getParameter("userSex"));
                String userPhone  = request.getParameter("userPhone");
                double userMoney  = request.getParameter("userMoney") == null ?
                        user.getUserMoney() : Double.parseDouble(request.getParameter("userMoney"));
                if(
                    !userPhone.equals( user.getUserPhone() )
                    &&  userDAO.selectCount( new QueryWrapper<User>().eq("user_phone",userPhone) )>0
                ){
                    ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
                    ajaxData.setMsg("手机号码已被其他人使用,请更换其他手机号码");
                    return ajaxData;
                }
                if(userMoney!=user.getUserMoney()){
                    UserMoney userMoneyData= new UserMoney();
                    userMoneyData.setMoney(userMoney-user.getUserMoney());
                    userMoneyData.setType(1);
                    userMoneyData.setUid(user.getId());
                    userMoneyDAO.addUserMoney(userMoneyData);
                    user.setUserMoney(userMoney);
                }
                user.setUserName(userName);
                user.setUserSex(userSex);
                user.setUserPhone(userPhone);
                result = userDAO.updateUser(user);
                if(result==0){
                    ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_FAILURE);
                }else{
                    ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_SUCCESS);
                }
            }
        }
        else if ( STOP.equals(type) || START.equals(type)){
            int state = Integer.parseInt(request.getParameter("state"));
            result = userDAO.updateUserStateByid(id,state);
            if(result==0){
                ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_FAILURE);
            }else{
                ajaxData.setStatus(AjaxDataMsg.STATUS_UPDATE_SUCCESS);
            }
        }
        else{
            ajaxData.setStatus(  AjaxDataMsg.STATUS_OTHER );
        }
        return ajaxData;
    }

    public AjaxData staffDataUpdate(HttpServletRequest request){
        int id   = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        return staffDataUpdate(id,type,request);
    }

    public AjaxData staffDataUpdate(int id,String type, HttpServletRequest request){

        if(DEL.equals(type)){
            int result = staffDAO.deleteById(id);
            if(result==0){
                ajaxData.setStatus( AjaxDataMsg.STATUS_DEL_FAILURE );
            }else{
                ajaxData.setStatus( AjaxDataMsg.STATUS_DEL_SUCCESS );
            }
        }
        else if (UPDATE.equals(type)){
            Staff staff = staffDAO.selectById(id);
            if(staff == null){
                ajaxData.setStatus(  AjaxDataMsg.STATUS_AJAX_FAILURE );
            }else{
                String staffName   = request.getParameter("staffName");
                int    staffSex    = Integer.parseInt(request.getParameter("staffSex"));
                String staffNo     = request.getParameter("staffNo");
                String staffPhone  = request.getParameter("staffPhone");
                String staffWeChat = request.getParameter("staffWeChat");
                if(
                     !staffPhone.equals( staff.getStaffPhone() )
                     && staffDAO.selectCount( new QueryWrapper<Staff>().eq("staff_phone",staffPhone) )>0
                ){
                    ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
                    ajaxData.setMsg("手机号码已被其他人使用,请更换其他手机号码");
                    return ajaxData;
                }
                staff.setStaffName(staffName);
                staff.setStaffSex(staffSex);
                staff.setStaffNo(staffNo);
                staff.setStaffPhone(staffPhone);
                staff.setStaffWechat(staffWeChat);
                int i = staffDAO.updateStaff(staff);
                if(i==0){
                    ajaxData.setStatus(  AjaxDataMsg.STATUS_UPDATE_FAILURE );
                }else{
                    ajaxData.setStatus(  AjaxDataMsg.STATUS_UPDATE_SUCCESS );
                }
            }
        }
        else{
            ajaxData.setStatus(  AjaxDataMsg.STATUS_OTHER );
        }
        return ajaxData;
    }

    public <T>AjaxData dataUpdate(int id,String type, HttpServletRequest request , T t){
        return new AjaxData();
    }

}