package com.w.dao.impl;

import com.w.dao.GoodDao;
import com.w.model.Good;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Repository
public class GoodDaoImpl implements GoodDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Good> getGoodByState(int state) {
        String hql = "from Good where state = ?";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql,state);
        return goods;
    }

    @Override
    public Good getGoodById(Good good) {
        String hql = "from Good where id = ?";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql,good.getId());
        if (goods.isEmpty()){
            return null;
        }
        return goods.get(0);
    }

    @Override
    public boolean updateGood(Good good) {
        hibernateTemplate.update(good);
        return true;
    }

    @Override
    public Good getGoodByNamePriceFactory(Good good) {
        String hql = "from Good where name = ? and price = ? and factory = ?";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql,good.getName(),good.getPrice(),good.getFactory());
        if (goods.isEmpty()){
            return null;
        }
        return goods.get(0);
    }

    @Override
    public boolean addGood(Good good) {
        hibernateTemplate.save(good);
        return true;
    }

    @Override
    public List<Good> getGoodByStateName(int state, String name1) {
        String hql = "from Good where state = ? and name like ?";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql,state,name1);
        return goods;
    }

    @Override
    public List<Good> getGoodByName(String name1) {
        String hql = "from Good where name like ?";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql,name1);
        return goods;
    }

    @Override
    public List<Good> getGood() {
        String hql = "from Good";
        List<Good> goods = (List<Good>) hibernateTemplate.find(hql);
        return goods;
    }
}
