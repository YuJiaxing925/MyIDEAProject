package com.yuntu.biz;

import com.yuntu.pojo.Student;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface StudentBiz {
    public void getPageAll(PageUtil<Student> pageUtil);
    public int delStudent(int id);
    public int updStudent(Student student);
    public int addStudent(Student student);
    public Student getStudent(int id);
}
