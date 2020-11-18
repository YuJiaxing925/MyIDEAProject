package com.yuntu.pojo;

import java.util.Date;

public class Employee {
    private int e_id;
    private String e_name;
    private String e_edu;
    private int e_r_id ;
    private Date e_hiredate;
    private int e_money;

    private  Role role;


    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_edu='" + e_edu + '\'' +
                ", e_r_id=" + e_r_id +
                ", e_hiredate=" + e_hiredate +
                ", e_money=" + e_money +
                " }";
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_edu() {
        return e_edu;
    }

    public void setE_edu(String e_edu) {
        this.e_edu = e_edu;
    }

    public int getE_r_id() {
        return e_r_id;
    }

    public void setE_r_id(int e_r_id) {
        this.e_r_id = e_r_id;
    }

    public Date getE_hiredate() {
        return e_hiredate;
    }

    public void setE_hiredate(Date e_hiredate) {
        this.e_hiredate = e_hiredate;
    }

    public int getE_money() {
        return e_money;
    }

    public void setE_money(int e_money) {
        this.e_money = e_money;
    }

    public Employee() {
    }

    public Employee(String e_name, String e_edu, int e_r_id, Date e_hiredate, int e_money) {
        this.e_name = e_name;
        this.e_edu = e_edu;
        this.e_r_id = e_r_id;
        this.e_hiredate = e_hiredate;
        this.e_money = e_money;
    }

    public Employee(int e_id, String e_name, String e_edu, int e_r_id, Date e_hiredate, int e_money) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_edu = e_edu;
        this.e_r_id = e_r_id;
        this.e_hiredate = e_hiredate;
        this.e_money = e_money;
    }
}
