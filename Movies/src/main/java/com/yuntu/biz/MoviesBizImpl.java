package com.yuntu.biz;

import com.yuntu.dao.MoviesMapper;
import com.yuntu.pojo.Movies;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class MoviesBizImpl implements  MoviesBiz{

    @Override
    public void getPageAll(PageUtil<Movies> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();

        int count = sqlSession.getMapper(MoviesMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(sqlSession.getMapper(MoviesMapper.class).getPageAll(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList());
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Override
    public int delMovies(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(MoviesMapper.class).delMovies(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updMovies(Movies movies) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(MoviesMapper.class).updMovies(movies);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int addMovies(Movies movies) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(MoviesMapper.class).addMovies(movies);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public Movies getMovies(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Movies movies = sqlSession.getMapper(MoviesMapper.class).getMovies(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return movies;
    }
}
