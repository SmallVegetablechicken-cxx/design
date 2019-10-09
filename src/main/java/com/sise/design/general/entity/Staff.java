package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/30 13:07
 * @Descript: TODO
 * @Version: 1.0
 */

public class Staff extends BaseEntity{

    private static final long SERIAL_VERSION_UID = 4414210753514761L;

    private String staffId;
    private String staffPassword;
    private String staffName;
    private String picture;
    private int    staffSex;
    private String staffPhone;
    private String staffWechat;
    private String staffBirthday;
    private int    staffClasses;
    private int    staffType;
    private String orgPass;
    private String staffNo;
    private int    state;

    public Staff() {
    }

    public Staff(int id, String staffId, String staffPassword, String staffName, int staffSex,
                 String staffPhone, String staffWechat, String staffBirthday, int staffClasses, int staffType,
                 String orgPass , String staffNo) {
        this.id=id;
        this.staffId = staffId;
        this.staffPassword = staffPassword;
        this.staffName = staffName;
        this.staffSex = staffSex;
        this.staffPhone = staffPhone;
        this.staffWechat = staffWechat;
        this.staffBirthday = staffBirthday;
        this.staffClasses = staffClasses;
        this.staffType = staffType;
        this.orgPass = orgPass;
        this.staffNo = staffNo;
    }


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(int staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffWechat() {
        return staffWechat;
    }

    public void setStaffWechat(String staffWechat) {
        this.staffWechat = staffWechat;
    }

    public String getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(String staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public int getStaffClasses() {
        return staffClasses;
    }

    public void setStaffClasses(int staffClasses) {
        this.staffClasses = staffClasses;
    }

    public int getStaffType() {
        return staffType;
    }

    public void setStaffType(int staffType) {
        this.staffType = staffType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOrgPass() {
        return orgPass;
    }

    public void setOrgPass(String orgPass) {
        this.orgPass = orgPass;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static long getSerialVersionUid() {
        return SERIAL_VERSION_UID;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", picture='" + picture + '\'' +
                ", staffSex=" + staffSex +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffWechat='" + staffWechat + '\'' +
                ", staffBirthday='" + staffBirthday + '\'' +
                ", staffClasses=" + staffClasses +
                ", staffType=" + staffType +
                ", staffNo=" + staffNo +
                '}';
    }

}
