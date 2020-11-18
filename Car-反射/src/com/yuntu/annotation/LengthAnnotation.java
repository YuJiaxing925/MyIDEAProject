package com.yuntu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthAnnotation {
    String value();//错误信息
    int max ();//最大长度
    int min();//最小长度
}
