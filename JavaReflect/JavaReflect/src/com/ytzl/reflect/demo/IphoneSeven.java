package com.ytzl.reflect.demo;

public class IphoneSeven extends Iphone{
    //自己特有属性和功能
    private String iphone7;

    public String getIphone7() {
        return iphone7;
    }

    public void setIphone7(String iphone7) {
        this.iphone7 = iphone7;
    }
    @Override
    public void show() {
        System.out.println("我是iphone 7.....");
    }
}
