package com.yuntu.test;

import com.yuntu.dao.BillMapper;
import com.yuntu.pojo.Bill;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class BillTest {
    private Logger log = Logger.getLogger(BillTest.class);
    @org.junit.Test
    public void getCountTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        //4.调用dao层方法
        //4-1.直接调用***Mapper.xml
        int num = sqlSession.selectOne("com.yuntu.dao.BillMapper.getCount");
        //4-2.
        int num1 = sqlSession.getMapper(BillMapper.class).getCount();
        log.debug("*******"+num+"*******"+num1);
        MybatisUtil.closeSqlSession(sqlSession);
    }
    @org.junit.Test
    public void getAllTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Bill> billList = sqlSession.getMapper(BillMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Bill b: billList) {
            log.debug(b.getId()+"----"+b.getProductName());
        }
    }
}
