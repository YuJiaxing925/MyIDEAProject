package com.yuntu.pojo;

import java.util.Date;

public class Information {
    private int i_id;
    private int i_sendOutId;
    private int i_receiveId;
    private String i_content;
    private int i_isRead;
    private String i_title;
    private Date i_createTime;

    public Information(int i_sendOutId, int i_receiveId, String i_content, int i_isRead, String i_title, Date i_createTime) {
        this.i_sendOutId = i_sendOutId;
        this.i_receiveId = i_receiveId;
        this.i_content = i_content;
        this.i_isRead = i_isRead;
        this.i_title = i_title;
        this.i_createTime = i_createTime;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getI_sendOutId() {
        return i_sendOutId;
    }

    public void setI_sendOutId(int i_sendOutId) {
        this.i_sendOutId = i_sendOutId;
    }

    public int getI_receiveId() {
        return i_receiveId;
    }

    public void setI_receiveId(int i_receiveId) {
        this.i_receiveId = i_receiveId;
    }

    public String getI_content() {
        return i_content;
    }

    public void setI_content(String i_content) {
        this.i_content = i_content;
    }

    public int getI_isRead() {
        return i_isRead;
    }

    public void setI_isRead(int i_isRead) {
        this.i_isRead = i_isRead;
    }

    public String getI_title() {
        return i_title;
    }

    public void setI_title(String i_title) {
        this.i_title = i_title;
    }

    public Date getI_createTime() {
        return i_createTime;
    }

    public void setI_createTime(Date i_createTime) {
        this.i_createTime = i_createTime;
    }

    public Information() {
    }

    public Information(int i_id, int i_sendOutId, int i_receiveId, String i_content, int i_isRead, String i_title, Date i_createTime) {
        this.i_id = i_id;
        this.i_sendOutId = i_sendOutId;
        this.i_receiveId = i_receiveId;
        this.i_content = i_content;
        this.i_isRead = i_isRead;
        this.i_title = i_title;
        this.i_createTime = i_createTime;
    }
}
