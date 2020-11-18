package com.yuntu.reflect;

public class BydTang extends Car{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void show() {
        System.out.println("这是一辆BydTang");
    }
}
