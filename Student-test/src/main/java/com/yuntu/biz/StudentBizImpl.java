package com.yuntu.biz;

import com.yuntu.dao.StudentMapper;
import com.yuntu.pojo.Student;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class StudentBizImpl implements  StudentBiz{
    @Override
    public void getPageAll(PageUtil<Student> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();

        int count = sqlSession.getMapper(StudentMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(sqlSession.getMapper(StudentMapper.class).getPageAll(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList());
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Override
    public int delStudent(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(StudentMapper.class).delStudent(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(StudentMapper.class).updStudent(student);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(StudentMapper.class).addStudent(student);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public Student getStudent(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Student student = sqlSession.getMapper(StudentMapper.class).getStudent(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return student;
    }
}
