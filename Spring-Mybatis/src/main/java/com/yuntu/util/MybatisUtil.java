package com.yuntu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    public static SqlSessionFactory factory = null;//全局作用域
    static {//静态代码块：运行在应用的最前面，且只运行一次 factory
        System.out.println("开始创建factory对象");

        try {
            //1.获取mybatis-config.xml的文件流
            InputStream is  = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建sqlSessionfactory工厂对象
            factory=  new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*开启sqlsession*/
    public static SqlSession createSqlSession (){
        return factory.openSession(false);
    }
    /*关闭sqlsession*/
    public static  void closeSqlSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }
}
