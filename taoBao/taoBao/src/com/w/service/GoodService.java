package com.w.service;

import com.w.model.Good;

import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public interface GoodService {
    List<Good> getGoodByState(int state);
    List<Good> queryCurrentPageGoodByState(int state, int currentPage, int pageSize);

    Good getGoodById(Good good);

    boolean updateGood(Good good);

    Good getGoodByNamePriceFactory(Good good);

    boolean addGood(Good good);

    List<Good> getGoodByStateName(int state, String name1);

    List<Good> queryCurrentPageByStateName(int state, String name1, int currentPage, int pageSize);

    List<Good> getGoodByName(String name1);

    List<Good> queryCurrentPageByName(String name1, int currentPage, int pageSize);

    List<Good> getGood();

    List<Good> queryCurrentPageGood(int currentPage, int pageSize);
}
