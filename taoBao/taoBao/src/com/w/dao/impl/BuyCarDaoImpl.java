package com.w.dao.impl;

import com.w.dao.BuyCarDao;
import com.w.model.BuyCar;
import com.w.model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
@Repository
public class BuyCarDaoImpl implements BuyCarDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BuyCar> getBuyCarByUser(User user) {
        String hql = "from BuyCar where user.id = ?";
        List<BuyCar> buyCars = (List<BuyCar>) hibernateTemplate.find(hql,user.getId());
        return buyCars;
    }

    @Override
    public boolean addBuyCar(BuyCar buyCar) {
        hibernateTemplate.save(buyCar);
        return true;
    }

    @Override
    public BuyCar getBuyCarByGood(BuyCar buyCar) {
        String hql = "from BuyCar where good.id = ?";
        List<BuyCar> buyCars = (List<BuyCar>) hibernateTemplate.find(hql,buyCar.getGood().getId());
        if (buyCars.isEmpty()){
            return null;
        }
        return buyCars.get(0);
    }

    @Override
    public boolean updateBuyCar(BuyCar buyCar1) {
        hibernateTemplate.update(buyCar1);
        return true;
    }

    @Override
    public boolean deleteBuyCar(BuyCar buyCar) {
        hibernateTemplate.delete(buyCar);
        return true;
    }

    @Override
    public BuyCar getBuyCarById(BuyCar buyCar) {
        String hql = "from BuyCar where id = ?";
        List<BuyCar> buyCars = (List<BuyCar>) hibernateTemplate.find(hql,buyCar.getId());
        if (buyCars.isEmpty()){
            return null;
        }
        return buyCars.get(0);
    }
}
