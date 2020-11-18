package com.yuntu.test;

import com.yuntu.dao.AddressMapper;
import com.yuntu.dao.RoleMapper;
import com.yuntu.pojo.Address;
import com.yuntu.pojo.Role;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class RoleTest {
    Logger log = Logger.getLogger(RoleTest.class);
    @Test
    public void getCountTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(RoleMapper.class).getCount();
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug("一共有"+num);
    }
    @Test
    public void getAllTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Role> roleList = sqlSession.getMapper(RoleMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Role r: roleList) {
            log.debug(r.getId()+"----"+r.getRoleName());
        }
    }
}
