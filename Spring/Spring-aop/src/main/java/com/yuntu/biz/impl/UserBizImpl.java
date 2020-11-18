package com.yuntu.biz.impl;

import com.yuntu.biz.UserBiz;
import com.yuntu.pojo.User;
import org.springframework.stereotype.Service;
@Service("UserBizImpl")
public class UserBizImpl implements UserBiz {


    public int addUser(User user ) throws RuntimeException{
        //前置增强
        System.out.println("执行添加User的方法");/*
        throw  new RuntimeException("运行时异常");*/

        //后置增强
        return 1;
    }
}
