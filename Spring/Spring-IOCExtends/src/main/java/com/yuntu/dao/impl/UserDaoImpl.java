package com.yuntu.dao.impl;

import com.yuntu.dao.UserDao;
import com.yuntu.entity.User;
import org.springframework.stereotype.Component;

//配置bean
@Component("UserDao")
public class UserDaoImpl implements UserDao {


    public User login(User user) {
        System.out.println("登录成功");
        return user;
    }
}
