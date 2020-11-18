package com.yuntu.biz;

import com.yuntu.pojo.Teacher;

import java.util.List;

public interface TeacherBiz {
    List<Teacher> getTeacherPositionById();
    public int delTeacherById(int id);
    public int updTeacher(Teacher teacher);
    public int addTeacher(Teacher teacher);
    public Teacher getTeacherById(int id);
}
