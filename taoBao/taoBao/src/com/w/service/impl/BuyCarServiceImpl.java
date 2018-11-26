package com.w.service.impl;

import com.w.dao.BuyCarDao;
import com.w.model.BuyCar;
import com.w.model.User;
import com.w.service.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
@Service
public class BuyCarServiceImpl implements BuyCarService{
    @Autowired
    private BuyCarDao buyCarDao = null;

    @Override
    public List<BuyCar> getBuyCarByUser(User user) {
        return buyCarDao.getBuyCarByUser(user);
    }

    @Override
    public List<BuyCar> queryCurrentPageBuyCarByUser(User user, int currentPage, int pageSize) {
        List<BuyCar> buyCarList = getBuyCarByUser(user);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<BuyCar> buyCars = new ArrayList<>();
        for (int i = begin; !buyCarList.isEmpty()&&(i<begin+end)&&i <buyCarList.size() ; i++) {
            buyCars.add(buyCarList.get(i));
        }
        return buyCars;
    }

    @Override
    public boolean addBuyCar(BuyCar buyCar) {
        BuyCar buyCar1 = getBuyCarByGood(buyCar);
        if (buyCar1==null){
            buyCarDao.addBuyCar(buyCar);
        }else{
            buyCar1.setGcount(buyCar1.getGcount()+buyCar.getGcount());
            buyCarDao.updateBuyCar(buyCar1);
        }
        return true;
    }

    @Override
    public boolean deleteBuyCar(BuyCar buyCar) {
        return buyCarDao.deleteBuyCar(buyCar);
    }

    @Override
    public BuyCar getBuyCarById(BuyCar buyCar) {
        return buyCarDao.getBuyCarById(buyCar);
    }

    @Override
    public boolean updateBuyCar(BuyCar buyCar) {
        return buyCarDao.updateBuyCar(buyCar);
    }

    public BuyCar getBuyCarByGood(BuyCar buyCar) {
        return buyCarDao.getBuyCarByGood(buyCar);
    }
}
