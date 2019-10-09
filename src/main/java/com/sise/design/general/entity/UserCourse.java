package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/5 16:50
 * @Descript: TODO
 * @Version: 1.0
 */

public class UserCourse extends BaseEntity {

    private static final long SERIAL_VERSION_UID = 4414210753514766L;

    private int    cid;
    private int    uid;
    private int    courseId;
    private int    exitId;
    private String remark;
    private String updateTime;
    private String exitTime;

    public UserCourse() {
    }

    @Override
    public String toString() {
        return "{" +
                "cid:" + cid +
                ", uid:" + uid +
                ", courseId:" + courseId +
                ", exitId:" + exitId +
                ", remark:'" + remark + '\'' +
                ", updateTime:'" + updateTime + '\'' +
                ", exitTime:'" + exitTime + '\'' +
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getExitId() {
        return exitId;
    }

    public void setExitId(int exitId) {
        this.exitId = exitId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
