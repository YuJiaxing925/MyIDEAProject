package com.yuntu.biz.impl;

import com.yuntu.biz.UserBiz;
import com.yuntu.dao.UserDao;
import com.yuntu.dao.impl.UserDaoImpl;
import com.yuntu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("UserBiz")
public class UserBizImpl implements UserBiz {
   //set注解注入
    //万一找不到匹配的bean会报错
    //如果bean中有匹配的参数则注入
    // 如果没有也不报错required = false

/*    @Autowired(required = false)
    @Qualifier("UserDao")*/
    //找到名为dao的bean
    //如果不带参数会自动找到属性名相同的bean
    @Resource(name = "UserDao")
    private UserDao userDao ;

    public UserDao getDao() {
        return userDao;
    }

    public void setDao(UserDao dao) {
        this.userDao = dao;
    }
    //构造注解注入
    @Autowired(required = false)
    public UserBizImpl(@Qualifier("UserDao") UserDao dao) {
        this.userDao = dao;
    }

    public UserBizImpl(){

    }
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
