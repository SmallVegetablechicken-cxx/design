package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/5 16:40
 * @Descript: TODO
 * @Version: 1.0
 */

public class Course extends BaseEntity {

    private static final long SERIAL_VERSION_UID = 4414210753514765L;

    private int    cid;
    private String courseType;
    private String courseName;
    private String courseStartTime;
    private String courseEndTime;
    private String courseDateType;
    private String courseDateNum;
    private String courseTimeType;
    private String courseTime;
    private String remark;

    public Course() {
    }

    @Override
    public String toString() {
        return "{" +
                "cid:" + cid +
                ", courseType:'" + courseType + '\'' +
                ", courseName:'" + courseName + '\'' +
                ", courseStartTime:'" + courseStartTime + '\'' +
                ", courseEndTime:'" + courseEndTime + '\'' +
                ", courseDateType:'" + courseDateType + '\'' +
                ", courseDateNum:'" + courseDateNum + '\'' +
                ", courseTimeType:'" + courseTimeType + '\'' +
                ", courseTime:'" + courseTime + '\'' +
                ", remark:'" + remark + '\'' +
                ", id:" + id +
                ", insertTime:'" + insertTime + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(String courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getCourseDateType() {
        return courseDateType;
    }

    public void setCourseDateType(String courseDateType) {
        this.courseDateType = courseDateType;
    }

    public String getCourseDateNum() {
        return courseDateNum;
    }

    public void setCourseDateNum(String courseDateNum) {
        this.courseDateNum = courseDateNum;
    }

    public String getCourseTimeType() {
        return courseTimeType;
    }

    public void setCourseTimeType(String courseTimeType) {
        this.courseTimeType = courseTimeType;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
