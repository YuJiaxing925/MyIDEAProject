package com.yuntu.pojo;

import java.util.Date;

public class Teacher {
    private int t_Id;
    private String t_name;
    private Date t_birthday;
    private String t_subject;
    private String t_sex;

    public int getT_Id() {
        return t_Id;
    }

    public void setT_Id(int t_Id) {
        this.t_Id = t_Id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Date getT_birthday() {
        return t_birthday;
    }

    public void setT_birthday(Date t_birthday) {
        this.t_birthday = t_birthday;
    }

    public String getT_subject() {
        return t_subject;
    }

    public void setT_subject(String t_subject) {
        this.t_subject = t_subject;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public Teacher(String t_name, Date t_birthday, String t_subject, String t_sex) {
        this.t_name = t_name;
        this.t_birthday = t_birthday;
        this.t_subject = t_subject;
        this.t_sex = t_sex;
    }

    public Teacher() {
    }

    public Teacher(int t_Id, String t_name, Date t_birthday, String t_subject, String t_sex) {
        this.t_Id = t_Id;
        this.t_name = t_name;
        this.t_birthday = t_birthday;
        this.t_subject = t_subject;
        this.t_sex = t_sex;
    }
}
