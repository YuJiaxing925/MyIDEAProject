package com.yuntu.test;

import com.yuntu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;

public class test {
    private Logger logger = Logger.getLogger(test.class);
    /*
    * 单元测试
    * */
    @Test
    public void test(){// 专门用来测试mapper方法

        String resource = "mybatis-config.xml";
        SqlSession sqlsession = null;
        try {
            //1.读取核心配置文件mybatis-config.xml
            InputStream is = Resources.getResourceAsStream(resource);
            //2.创建sqlsessionfactory 读取配置文件
            SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);
            //3.开启sqlsession
            sqlsession = factory.openSession();
            //4.调用mapper提供的方法
            int count = sqlsession.getMapper(UserMapper.class).count();
            logger.debug(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
    }
}