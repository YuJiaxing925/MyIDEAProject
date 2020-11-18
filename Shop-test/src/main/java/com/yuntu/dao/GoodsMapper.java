package com.yuntu.dao;

import com.yuntu.pojo.Goods;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface GoodsMapper {
    List<Goods> getGoodsByPage(PageUtil<Goods> pageUtil);
    int getCount();
    int addGoods(Goods goods);
    int updGoods(Goods goods);
    int delGoodsById(int id);
    Goods getGoodsById(int id);
}
