package com.yuntu.biz;

import com.yuntu.dao.GoodsMapper;
import com.yuntu.pojo.Goods;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class GoodsBizImpl implements GoodsBiz{
    @Override
    public void getGoodsByPage(PageUtil<Goods> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int count = sqlSession.getMapper(GoodsMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(sqlSession.getMapper(GoodsMapper.class).getGoodsByPage(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList<Goods>());
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Override
    public int addGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(GoodsMapper.class).addGoods(goods);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(GoodsMapper.class).updGoods(goods);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int delGoodsById(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(GoodsMapper.class).delGoodsById(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public Goods getGoodsById(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Goods employee =  sqlSession.getMapper(GoodsMapper.class).getGoodsById(id);
        MybatisUtil.closeSqlSession(sqlSession);
        return employee;
    }
}
