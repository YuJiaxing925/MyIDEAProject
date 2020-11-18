package com.yuntu.pojo;

public class Student {
    private int id;
    private String t_stu_name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", t_stu_name='" + t_stu_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_stu_name() {
        return t_stu_name;
    }

    public void setT_stu_name(String t_stu_name) {
        this.t_stu_name = t_stu_name;
    }

    public Student(int id, String t_stu_name) {
        this.id = id;
        this.t_stu_name = t_stu_name;
    }
}
