package com.ytzl.reflect.demo;

/**
 * 苹果手机
 * iphone 6
 * iphone 7
 * iphone 8
 */
public class Test {
    public static void main(String[] args){
        /**
         * 里式替换原则是实现多态的基础
         * 子类对象可以到父类变量中
         *
         *
         */
//        Iphone iphone=Factory.createIphone("iphone6");
//        iphone.show();

        Iphone iphone=Factory.createIphone("com.ytzl.reflect.demo.IphoneEleven");
        iphone.show();
        iphone=Factory.createIphone("com.ytzl.reflect.demo.IphoneTwelve");
        iphone.show();

    }
}
