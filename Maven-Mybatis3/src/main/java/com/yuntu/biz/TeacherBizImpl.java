package com.yuntu.biz;

import com.yuntu.dao.TeacherMapper;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherBizImpl implements  TeacherBiz{

    public List<Teacher> getTeacherPositionById() {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Teacher> t = sqlSession.getMapper(TeacherMapper.class).getTeacherPositionById();
        MybatisUtil.closeSqlSession(sqlSession);
        return t;
    }
    public int delTeacherById(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).delTeacherById(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }
    public int addTeacher(Teacher teacher) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).addTeacher(teacher);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }
    public Teacher getTeacherById(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Teacher t = sqlSession.getMapper(TeacherMapper.class).getTeacherById(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return t;
    }
    public int updTeacher(Teacher teacher) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).updTeacher(teacher);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }
}
