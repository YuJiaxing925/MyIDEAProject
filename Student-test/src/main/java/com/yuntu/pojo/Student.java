package com.yuntu.pojo;

import java.util.Date;

public class Student {
    private int stu_id;
    private String stu_name;
    private int stu_age;
    private Date stu_time;
    private Score score;

    public Student() {
    }

    public Score getScore() {
        return score;
    }

    public Student(int stu_id, String stu_name, int stu_age) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_age = stu_age;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Student(String stu_name, int stu_age, Date stu_time) {
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.stu_time = stu_time;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getStu_age() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public Date getStu_time() {
        return stu_time;
    }

    public void setStu_time(Date stu_time) {
        this.stu_time = stu_time;
    }

    public Student(int stu_id, String stu_name, int stu_age, Date stu_time) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.stu_time = stu_time;
    }

    public Student(String stu_name, int stu_age) {
        this.stu_name = stu_name;
        this.stu_age = stu_age;
    }
}
