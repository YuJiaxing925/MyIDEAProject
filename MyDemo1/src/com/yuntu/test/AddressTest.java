package com.yuntu.test;

import com.yuntu.dao.AddressMapper;
import com.yuntu.pojo.Address;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class AddressTest {
    Logger log = Logger.getLogger(AddressTest.class);
    @Test
    public void getCountTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(AddressMapper.class).getCount();
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug("一共有"+num);
    }
    @Test
    public void getAllTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Address> addressList = sqlSession.getMapper(AddressMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Address a: addressList) {
            log.debug(a.getId()+"---------"+a.getContact());
        }
    }
}
