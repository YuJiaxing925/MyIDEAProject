package com.yuntu.biz;

import com.yuntu.dao.UserMapper;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userBiz")
public class UserBizImpl  implements UserBiz{
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserBizImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    public UserBizImpl() {
    }
}