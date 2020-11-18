package com.yuntu.pojo;

public class Goods {
    private int id;
    private String name;
    private int s_id;
    private String color;
    private String money;

    private Sort sort;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Goods(String name, int s_id, String color, String money) {
        this.name = name;
        this.s_id = s_id;
        this.color = color;
        this.money = money;
    }

    public Goods() {
    }

    public Goods(int id, String name, int s_id, String color, String money) {
        this.id = id;
        this.name = name;
        this.s_id = s_id;
        this.color = color;
        this.money = money;
    }
}
