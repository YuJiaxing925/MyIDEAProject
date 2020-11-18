package com.yuntu.dao;

import com.yuntu.pojo.Movies;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface MoviesMapper {
    public List<Movies> getPageAll(PageUtil<Movies> pageUtil);
    public int getCount();
    public int delMovies(int id);
    public int updMovies(Movies movies);
    public int addMovies(Movies movies);
    public Movies getMovies(int id);
}
