package com.yuntu.dao;

import com.yuntu.pojo.Teacher;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface TeacherMapper {
    //分页查询
    List<Teacher> getPageAll(PageUtil<Teacher> pageUtil);
    //查询单个teacher
    Teacher getTeacher(int id );
    //删除teacher
    int delTeacher(int id);
    //添加teacher
    int addTeacher(Teacher teacher);
    //修改teahcer
    int updTeacher(Teacher teacher);
    //获取条目数
    int getCount();
}
