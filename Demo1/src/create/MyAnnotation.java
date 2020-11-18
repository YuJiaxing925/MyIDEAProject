package create;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试自定义注解
 *      之所以自定义注解、是因为，
 *      需要再程序运行的过程中读取注解所携带的数据
 */
@Target({ElementType.TYPE,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.METHOD})//表示当前自定义的注解可以再类、接口、枚举类型上使用
@Retention(RetentionPolicy.CLASS)//表示当前的注解只能再编码阶段使用
public @interface MyAnnotation {
//至少再自定义注解中要包含一个value成员变量
    String value();
    int age();
    String name() default "张三";//携带默认值的一般都放到最后

}
