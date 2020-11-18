package com.yuntu.biz;

import com.yuntu.dao.TeacherMapper;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class TeacherBizImpl implements  TeacherBiz{

    @Override
    public void getPageAll(PageUtil<Teacher> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();

        int count = sqlSession.getMapper(TeacherMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(sqlSession.getMapper(TeacherMapper.class).getPageAll(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList());
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Override
    public Teacher getTeacher(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Teacher teacher= sqlSession.getMapper(TeacherMapper.class).getTeacher(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return teacher;
    }

    @Override
    public int delTeacher(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).delTeacher(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).addTeacher(teacher);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updTeacher(Teacher teacher) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(TeacherMapper.class).updTeacher(teacher);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }
}
