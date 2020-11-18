package com.ytzl.reflect.demo;

public class IphoneTen extends Iphone{
    private String iphone10;

    public String getIphone10() {
        return iphone10;
    }

    public void setIphone10(String iphone10) {
        this.iphone10 = iphone10;
    }

    @Override
    public void show() {
        System.out.println("我是iphone 10");
    }
}
