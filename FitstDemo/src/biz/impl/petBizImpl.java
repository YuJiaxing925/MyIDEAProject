package biz.impl;

import biz.petBiz;
import dao.impl.petDaoImpl;
import dao.petDao;
import entity.pet;

import java.util.List;

public class petBizImpl implements petBiz {
    petDao petDao = new petDaoImpl();
    public List<pet> getall() {
        return petDao.getall();
    }
}
