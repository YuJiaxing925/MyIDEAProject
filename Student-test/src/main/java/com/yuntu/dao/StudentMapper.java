package com.yuntu.dao;

import com.yuntu.pojo.Student;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface StudentMapper {
    public List<Student> getPageAll(PageUtil<Student> pageUtil);
    public int getCount();
    public int delStudent(int id);
    public int updStudent(Student student);
    public int addStudent(Student student);
    public Student getStudent(int id);
}
