package com.yuntu.biz;

import com.yuntu.pojo.Friend;
import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBiz {
    void getUserByPage(PageUtil<User> pageUtil);
    int addUser(User user);
    int updUser(User user);
    User getUserById(int id);
    User Login( String username, String password);
    int getRole(int id);
    List<User> getUserFriendByUserFriendId(int id);
    int delFriend( int id1, int id2 );
    int addFriend(Friend friend);
}
