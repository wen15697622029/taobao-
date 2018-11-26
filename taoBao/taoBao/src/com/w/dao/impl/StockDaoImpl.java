package com.w.dao.impl;

import com.w.dao.StockDao;
import com.w.model.Good;
import com.w.model.Stock;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Repository
public class StockDaoImpl implements StockDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean updateStock(Stock stock) {
        hibernateTemplate.merge(stock);
        return true;
    }

    @Override
    public Stock getStockByGood(Good good) {
        String hql = "from Stock where good.id = ?";
        List<Stock> stocks = (List<Stock>) hibernateTemplate.find(hql,good.getId());
        if (stocks.isEmpty()){
            return null;
        }
        return stocks.get(0);
    }
}
