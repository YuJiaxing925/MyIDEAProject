package com.yuntu.dao;

import com.yuntu.pojo.Address;
import com.yuntu.pojo.Bill;

import java.util.List;

public interface AddressMapper {
    //查询总条目数
    int getCount();
    //查询全部订单
    List<Address> getAll();
}
