package com.yuntu.biz;

import com.yuntu.pojo.Goods;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface GoodsBiz {
    void getGoodsByPage(PageUtil<Goods> pageUtil);
    int addGoods(Goods goods);
    int updGoods(Goods goods);
    int delGoodsById(int id);
    Goods getGoodsById(int id);
}
