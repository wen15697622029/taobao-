package com.w.dao;

import com.w.model.BuyCar;
import com.w.model.User;

import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
public interface BuyCarDao {

    List<BuyCar> getBuyCarByUser(User user);

    boolean addBuyCar(BuyCar buyCar);

    BuyCar getBuyCarByGood(BuyCar buyCar);

    boolean updateBuyCar(BuyCar buyCar1);

    boolean deleteBuyCar(BuyCar buyCar);

    BuyCar getBuyCarById(BuyCar buyCar);
}
