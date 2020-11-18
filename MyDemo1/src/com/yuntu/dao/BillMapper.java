package com.yuntu.dao;

import com.yuntu.pojo.Bill;

import java.util.List;

public interface BillMapper {
    //查询总条目数
    int getCount();
    //查询全部订单
    List<Bill> getAll();
}
