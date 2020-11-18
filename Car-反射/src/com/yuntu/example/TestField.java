package com.yuntu.example;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射获取属性信息
 */
public class TestField {
    public static void main(String[] args) {
        //获取Person类的class对现象
        Class cls = Person.class;
        //获取Person类中的公共的属性对象
        Field[] fields = cls.getFields();
        for(Field f: fields){
            System.out.println("属性名称"+f.getName());
            System.out.println("属性类型"+f.getType());
            System.out.println("访问修饰符"+f.getModifiers());
        }
        System.out.println("\n");
        //获取所有的字段
        Field[] filedsAll = cls.getDeclaredFields();
        for(Field f: filedsAll){
            System.out.println("属性名称"+f.getName());
            System.out.println("属性类型"+f.getType());
            System.out.println("访问修饰符"+f.getModifiers());
            //获取属性上的注解
            Annotation[] annos = f.getDeclaredAnnotations();
            for(Annotation a: annos){
                System.out.println(a);
            }
        }
    }
}
