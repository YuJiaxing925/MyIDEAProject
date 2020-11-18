package com.ytzl.reflect.demo;

public class IphoneTwelve extends Iphone{
    private String iphone12;

    public String getIphone12() {
        return iphone12;
    }

    public void setIphone12(String iphone12) {
        this.iphone12 = iphone12;
    }

    @Override
    public void show() {
        System.out.println("iphone 12");
    }
}
