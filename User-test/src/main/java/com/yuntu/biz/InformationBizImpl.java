package com.yuntu.biz;

import com.yuntu.dao.InformationMapper;
import com.yuntu.dao.UserMapper;
import com.yuntu.pojo.Information;
import com.yuntu.pojo.User;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class InformationBizImpl implements InformationBiz {
    @Override
    public int sendMail(Information information) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(InformationMapper.class).sendMail(information);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public List<Information> getInformation(int i_receiveId) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Information> informationList =  sqlSession.getMapper(InformationMapper.class).getInformation(i_receiveId);
        MybatisUtil.closeSqlSession(sqlSession);
        return informationList;
    }

    @Override
    public int isRead(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(InformationMapper.class).isRead(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public Information readInformation(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Information Information =  sqlSession.getMapper(InformationMapper.class).readInformation(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return Information;
    }
}
