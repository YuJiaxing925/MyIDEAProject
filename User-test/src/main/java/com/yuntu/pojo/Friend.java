package com.yuntu.pojo;

import java.util.Date;

public class Friend {
    private int f_id;
    private int f_userID;
    private int f_friendsUserID;
    private String f_remarks;
    private Date f_createTime;

    public Friend() {
    }

    @Override
    public String toString() {
        return "Friend{" +
                "f_id=" + f_id +
                ", f_userID=" + f_userID +
                ", f_friendsUserID=" + f_friendsUserID +
                ", f_remarks='" + f_remarks + '\'' +
                ", f_createTime=" + f_createTime +
                '}';
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getF_userID() {
        return f_userID;
    }

    public void setF_userID(int f_userID) {
        this.f_userID = f_userID;
    }

    public int getF_friendsUserID() {
        return f_friendsUserID;
    }

    public void setF_friendsUserID(int f_friendsUserID) {
        this.f_friendsUserID = f_friendsUserID;
    }

    public String getF_remarks() {
        return f_remarks;
    }

    public void setF_remarks(String f_remarks) {
        this.f_remarks = f_remarks;
    }

    public Date getF_createTime() {
        return f_createTime;
    }

    public void setF_createTime(Date f_createTime) {
        this.f_createTime = f_createTime;
    }

    public Friend(int f_userID, int f_friendsUserID, String f_remarks, Date f_createTime) {
        this.f_userID = f_userID;
        this.f_friendsUserID = f_friendsUserID;
        this.f_remarks = f_remarks;
        this.f_createTime = f_createTime;
    }

    public Friend(int f_id, int f_userID, int f_friendsUserID, String f_remarks, Date f_createTime) {
        this.f_id = f_id;
        this.f_userID = f_userID;
        this.f_friendsUserID = f_friendsUserID;
        this.f_remarks = f_remarks;
        this.f_createTime = f_createTime;
    }
}
