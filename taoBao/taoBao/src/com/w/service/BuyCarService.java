package com.w.service;

import com.w.model.BuyCar;
import com.w.model.User;

import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
public interface BuyCarService {

    List<BuyCar> getBuyCarByUser(User user);

    List<BuyCar> queryCurrentPageBuyCarByUser(User user, int currentPage, int pageSize);

    boolean addBuyCar(BuyCar buyCar);

    boolean deleteBuyCar(BuyCar buyCar);

    BuyCar getBuyCarById(BuyCar buyCar);

    boolean updateBuyCar(BuyCar buyCar);
}
