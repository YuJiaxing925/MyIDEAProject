package com.yuntu.dao;

import com.yuntu.pojo.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    Position getTeacherByPositionId(@Param("id") int id);
    List<Position> getAll();
    Position selTeacherStudentByPositionId(@Param("pid")int id);
}
