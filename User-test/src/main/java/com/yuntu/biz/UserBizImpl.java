package com.yuntu.biz;

import com.yuntu.dao.UserMapper;
import com.yuntu.pojo.Friend;
import com.yuntu.pojo.User;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserBizImpl implements  UserBiz{
    @Override
    public void getUserByPage(PageUtil<User> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int count = sqlSession.getMapper(UserMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(sqlSession.getMapper(UserMapper.class).getUserByPage(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList<User>());
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Override
    public int addUser(User user) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(UserMapper.class).addUser(user);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updUser(User user) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(UserMapper.class).updUser(user);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public User getUserById(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        User user =  sqlSession.getMapper(UserMapper.class).getUserById(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User Login(String username, String password) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        User user =  sqlSession.getMapper(UserMapper.class).Login(username,password);
        MybatisUtil.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public int getRole(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(UserMapper.class).getRole(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public List<User> getUserFriendByUserFriendId(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<User> userList =  sqlSession.getMapper(UserMapper.class).getUserFriendByUserFriendId(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return userList;
    }

    @Override
    public int delFriend(int id1, int id2) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(UserMapper.class).delFriend(id1,id2);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int addFriend(Friend friend) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(UserMapper.class).addFriend(friend);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }
}
