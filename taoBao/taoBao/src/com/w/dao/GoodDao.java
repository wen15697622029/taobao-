package com.w.dao;

import com.w.model.Good;

import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public interface GoodDao {

    List<Good> getGoodByState(int state);

    Good getGoodById(Good good);

    boolean updateGood(Good good);

    Good getGoodByNamePriceFactory(Good good);

    boolean addGood(Good good);

    List<Good> getGoodByStateName(int state, String name1);

    List<Good> getGoodByName(String name1);

    List<Good> getGood();
}
