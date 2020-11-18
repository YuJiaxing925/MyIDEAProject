package com.ytzl.reflect.demo;

/**
 * 在程序中频繁创建对象时
 */
public class Factory {
    /**
     *创建手机
     * @param className 类的完全限定名称
     * @return
     */
    public static Iphone createIphone(String className){
        Iphone iphone=null;
        try {
            //使用反射机制实现开闭原则
            iphone=(Iphone)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iphone;
//        Iphone iphone=null;
//        switch (type){
//            case "iphone6":
//                iphone=new IphoneSix();
//                break;
//            case "iphone7":
//                iphone=new IphoneSeven();
//                break;
//            case "iphone8":
//                iphone=new IphoneEight();
//                break;
//            case "iphone9":
//                iphone=new IphoneNine();
//                break;
//            case "iphone10":
//                iphone=new IphoneTen();
//                break;
//        }
//        return iphone;
    }
}
