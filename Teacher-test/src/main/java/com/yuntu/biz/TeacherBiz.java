package com.yuntu.biz;

import com.yuntu.pojo.Teacher;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface TeacherBiz {
    void getPageAll(PageUtil<Teacher> pageUtil);
    Teacher getTeacher(int id );
    int delTeacher(int id);
    int addTeacher(Teacher teacher);
    int updTeacher(Teacher teacher);
}
