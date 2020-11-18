package com.yuntu.biz;

import com.yuntu.dao.PositionMapper;
import com.yuntu.dao.TeacherMapper;
import com.yuntu.pojo.Position;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PositionBizImpl implements PositionBiz{
    public List<Position> getAll() {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Position> p = sqlSession.getMapper(PositionMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        return  p;
    }
}
