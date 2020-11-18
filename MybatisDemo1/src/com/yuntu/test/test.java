package com.yuntu.test;

import com.yuntu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {
    private Logger logger = Logger.getLogger(Test.class);//创建日志工具
    @Test
    public void test(){//专门用来测试某个mapper方法
        String resource="mybatis-config.xml";
        SqlSession sqlSession=null;
        try {
            //1.读取核心配置文件mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            //2.创建sqlSessionFactory对象，读取配置文件
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            //3.创建sqlSession对象
             sqlSession = factory.openSession();
            //4.调用Mapper提供的方法
            int count = sqlSession.getMapper(UserMapper.class).count();
            logger.debug("一共有"+count+"员工");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
