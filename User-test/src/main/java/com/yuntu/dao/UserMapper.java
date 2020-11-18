package com.yuntu.dao;

import com.yuntu.pojo.Friend;
import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserByPage(PageUtil<User> pageUtil);
    int getCount();
    int addUser(User user);
    int updUser(User user);
    User getUserById(int id);
    User Login(@Param("username") String username,@Param("password") String password);
    int getRole(int id);
    List<User> getUserFriendByUserFriendId(int id);
    int delFriend(@Param("id1") int id1,@Param("id2") int id2 );
    int addFriend(Friend friend);
}
