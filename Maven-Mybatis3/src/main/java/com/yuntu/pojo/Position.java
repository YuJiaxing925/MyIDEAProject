package com.yuntu.pojo;

import java.util.List;

public class Position {
    private int id;
    private String t_pos_name;
    List<Teacher> tlist ;

    public List<Teacher> getTlist() {
        return tlist;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", t_pos_name='" + t_pos_name + '\'';
    }

    public void setTlist(List<Teacher> tlist) {
        this.tlist = tlist;
    }

    public Position(int id, String t_pos_name) {
        this.id = id;
        this.t_pos_name = t_pos_name;
        }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_pos_name() {
        return t_pos_name;
    }

    public void setT_pos_name(String t_pos_name) {
        this.t_pos_name = t_pos_name;
    }

    public Position(String t_pos_name) {
        this.t_pos_name = t_pos_name;
    }
}
