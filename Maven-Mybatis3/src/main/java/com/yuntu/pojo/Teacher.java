package com.yuntu.pojo;

import java.util.List;

public class Teacher {
    private int id;
    private String t_no;
    private String t_name;
    private int position_id;

    //多表联查多的一个参数
    private  Position p;
    private List<Student> studentList;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", t_no='" + t_no + '\'' +
                ", t_name='" + t_name + '\'' +
                ", position_id=" + position_id +
                '}';
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_no() {
        return t_no;
    }

    public Teacher() {
    }

    public void setT_no(String t_no) {
        this.t_no = t_no;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public Teacher(String t_no, String t_name, int position_id) {
        this.t_no = t_no;
        this.t_name = t_name;
        this.position_id = position_id;
    }

    public Teacher(int id, String t_no, String t_name, int position_id) {
        this.id = id;
        this.t_no = t_no;
        this.t_name = t_name;
        this.position_id = position_id;
    }
}
