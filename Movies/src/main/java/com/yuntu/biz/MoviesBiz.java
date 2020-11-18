package com.yuntu.biz;

import com.yuntu.pojo.Movies;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface MoviesBiz {
    public void getPageAll(PageUtil<Movies> pageUtil);
    public int delMovies(int id);
    public int updMovies(Movies movies);
    public int addMovies(Movies movies);
    public Movies getMovies(int id);
}
