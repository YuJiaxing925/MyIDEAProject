package com.ytzl.reflect.demo;

/**
 *
 * 高可维护， 高可扩展
 * 开闭原则
 * 高内聚， 低耦合
 *
 * 11
 */
public class IphoneEleven extends Iphone{
    private String iphone11;

    public String getIphone11() {
        return iphone11;
    }

    public void setIphone11(String iphone11) {
        this.iphone11 = iphone11;
    }

    @Override
    public void show() {
        System.out.println("iphone 11");
    }
}
