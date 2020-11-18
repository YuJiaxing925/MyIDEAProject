package com.yuntu.dao;

import com.yuntu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> getTeacherPositionById();
    public int delTeacherById(int id);
    public int updTeacher(Teacher teacher);
    public int addTeacher(Teacher teacher);
    public Teacher getTeacherById(int id);
    public List<Teacher> getAll(@Param("t_name") String t_name, @Param("position_id") Integer position_id);
    public int updTeacher1(Teacher teacher);
}