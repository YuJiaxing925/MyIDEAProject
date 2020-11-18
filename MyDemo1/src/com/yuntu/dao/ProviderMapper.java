package com.yuntu.dao;

import com.yuntu.pojo.Bill;
import com.yuntu.pojo.Provider;

import java.util.List;

public interface ProviderMapper {
    //查询总条目数
    int getCount();
    //查询全部订单
    List<Provider> getAll();
}
