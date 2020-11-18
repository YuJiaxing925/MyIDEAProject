package com.ytzl.reflect.demo;

/**
 * 8
 */
public class IphoneEight extends Iphone{
    private String iphone8;

    public String getIphone8() {
        return iphone8;
    }

    public void setIphone8(String iphone8) {
        this.iphone8 = iphone8;
    }

    @Override
    public void show() {
        System.out.println("我是iphone 8");
    }
}
