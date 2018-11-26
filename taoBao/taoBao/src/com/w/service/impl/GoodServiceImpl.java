package com.w.service.impl;

import com.w.dao.GoodDao;
import com.w.model.Good;
import com.w.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodDao goodDao = null;

    @Override
    public List<Good> getGoodByState(int state) {
        return goodDao.getGoodByState(state);
    }

    @Override
    public List<Good> queryCurrentPageGoodByState(int state, int currentPage, int pageSize) {
        List<Good> goodList = getGoodByState(state);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Good> goods = new ArrayList<>();
        for (int i = begin; (i<begin+end)&&i <goodList.size() ; i++) {
            goods.add(goodList.get(i));
        }
        return goods;
    }

    @Override
    public Good getGoodById(Good good) {
        return goodDao.getGoodById(good);
    }

    @Override
    public boolean updateGood(Good good) {
        return goodDao.updateGood(good);
    }

    @Override
    public Good getGoodByNamePriceFactory(Good good) {
        return goodDao.getGoodByNamePriceFactory(good);
    }

    @Override
    public boolean addGood(Good good) {
        return goodDao.addGood(good);
    }

    @Override
    public List<Good> getGoodByStateName(int state, String name1) {
        return goodDao.getGoodByStateName(state,name1);
    }

    @Override
    public List<Good> queryCurrentPageByStateName(int state, String name1, int currentPage, int pageSize) {
        List<Good> goodList = getGoodByStateName(state,name1);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Good> goods = new ArrayList<>();
        for (int i = begin; !goodList.isEmpty()&&(i<begin+end)&&i <goodList.size() ; i++) {
            goods.add(goodList.get(i));
        }
        return goods;
    }

    @Override
    public List<Good> getGoodByName(String name1) {
        return goodDao.getGoodByName(name1);
    }

    @Override
    public List<Good> queryCurrentPageByName(String name1, int currentPage, int pageSize) {
        List<Good> goodList = getGoodByName(name1);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Good> goods = new ArrayList<>();
        for (int i = begin; !goodList.isEmpty()&&(i<begin+end)&&i <goodList.size() ; i++) {
            goods.add(goodList.get(i));
        }
        return goods;
    }

    @Override
    public List<Good> getGood() {
        return goodDao.getGood();
    }

    @Override
    public List<Good> queryCurrentPageGood(int currentPage, int pageSize) {
        List<Good> goodList = getGood();
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Good> goods = new ArrayList<>();
        for (int i = begin; !goodList.isEmpty()&&(i<begin+end)&&i <goodList.size() ; i++) {
            goods.add(goodList.get(i));
        }
        return goods;
    }
}
