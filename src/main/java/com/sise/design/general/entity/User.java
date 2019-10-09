package com.sise.design.general.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/1 13:00
 * @Descript: TODO
 * @Version: 1.0
 */

public class User extends BaseEntity{

    private static final long SERIAL_VERSION_UID = 4414210753514762L;

    private String userId;
    private String userPassword;
    private String userName;
    private int    userSex;
    private String userPhone;
    private double userMoney;
    private String remark;
    private int    state;

    @TableField(exist=false)
    private int    wages;
    @TableField(exist=false)
    private String wagesTime;
    @TableField(exist=false)
    private String updateTime;
    @TableField(exist=false)
    private UserWages userWages;



    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", userId:'" + userId + '\'' +
                ", userPassword:'" + userPassword + '\'' +
                ", userName:'" + userName + '\'' +
                ", userSex:" + userSex +
                ", userPhone:'" + userPhone + '\'' +
                ", userMoney:" + userMoney +
                ", remark:'" + remark + '\'' +
                ", insertTime:'" + insertTime + '\'' +
                ", state:" + state +
                ", wages:" + wages +
                ", wagesTime:'" + wagesTime + '\'' +
                ", updateTime:'" + updateTime + '\'' +
                ", userWages:" + userWages.toString() +
                '}';
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public String getWagesTime() {
        return wagesTime;
    }

    public void setWagesTime(String wagesTime) {
        this.wagesTime = wagesTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public UserWages getUserWages() {
        return userWages;
    }

    public void setUserWages(UserWages userWages) {
        this.userWages = userWages;
    }
}
