package com.ytzl.reflect.demo;

public class IphoneNine extends Iphone{
    private String iphone9;

    public String getIphone9() {
        return iphone9;
    }

    public void setIphone9(String iphone9) {
        this.iphone9 = iphone9;
    }

    @Override
    public void show() {
        System.out.println("我是iphone 9...");
    }
}
