package com.ytzl.reflect.example;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args){
        //使用Class.forName()获取类的Class对象， 在完全不知道要去创建对象的类的名字
        try {
            Class cls=Class.forName("com.ytzl.reflect.example.Person");
            System.out.println("类的名称："+cls.getSimpleName());
            System.out.println("类的完全限定名称："+cls.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //使用类名.class的方式获取类的Class对象，  获取类的中信息
        Class cls1=Person.class;
        System.out.println("类的完全限定名称："+cls1.getTypeName());

        //使用已经创建的对象获取类的Class对象，  获取类的中信息
        Person p=new Person();
        Class cls2=p.getClass();
        System.out.println("类的完全限定名称："+cls1.getTypeName());
        if (true){
            System.out.println(1);
        }
    }
}
