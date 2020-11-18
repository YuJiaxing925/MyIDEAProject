package dao.impl;

import dao.petDao;
import entity.pet;
import util.BaseDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class petDaoImpl extends BaseDao implements petDao {
    public List<pet> getall() {
        List<pet> petList = new ArrayList<pet>();
        String sql = "select * from pet";
        rs = myexecuteQuery(sql,null);
        try {
            while (rs.next()) {
                pet p = new pet(rs.getString(1),rs.getInt(2));
                petList.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return petList;
    }
}
