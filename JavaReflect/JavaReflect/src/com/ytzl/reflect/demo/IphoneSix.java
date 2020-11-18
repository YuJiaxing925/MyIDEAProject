package com.ytzl.reflect.demo;

/**
 * Iphone 6手机类
 */
public class IphoneSix extends Iphone{

    //自己特有属性和功能
    private String iphone6;

    public String getIphone6() {
        return iphone6;
    }

    public void setIphone6(String iphone6) {
        this.iphone6 = iphone6;
    }

    @Override
    public void show() {
        System.out.println("我是iphone 6");
    }
}
