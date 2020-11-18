package com.ytzl.reflect.example;

import com.ytzl.reflect.annotation.LengthAnnotation;

/**
 * 人类
 */
@Deprecated
public class Person {
    @LengthAnnotation(value="名称长度不合法",max = 10,min=6)
    private String name;
    private int age;
    public char sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private void show(){

    }

    public Person(){}

    public Person(String name,int age){
        this.setName(name);
        this.setAge(age);
    }
}
