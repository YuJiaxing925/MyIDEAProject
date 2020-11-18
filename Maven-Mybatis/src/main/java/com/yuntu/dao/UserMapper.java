package com.yuntu.dao;
import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询总条目数
    int getCount();
    //查询全部一对一
    List<User> getAll();
    //查询全部一对多
    List<User> getAll2();
    //删除
    int delUser(int id);
    //添加
    int addUser(User u);
    //修改
    int updUser(User u);
    //模糊查询
    List<User> getLike(String likestr);
    //模糊查询-实体类
    List<User> getLike2(User u);
    //模糊查询-Map
    List<User> getLike3(Map map );
    //模糊查询，多参
    List<User> getLike4(@Param("aaa") String likestr , @Param("bbb") int gender);
}