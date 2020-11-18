package com.yuntu.dao;

import com.yuntu.pojo.Bill;
import com.yuntu.pojo.Role;

import java.util.List;

public interface RoleMapper {
    //查询总条目数
    int getCount();
    //查询全部订单
    List<Role> getAll();
}
