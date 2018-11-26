package com.w.service.impl;

import com.w.dao.StockDao;
import com.w.model.Good;
import com.w.model.Stock;
import com.w.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Service
public class StockServiceImpl implements StockService{
    @Autowired
    private StockDao stockDao = null;

    @Override
    public boolean updateStock(Stock stock) {
        return stockDao.updateStock(stock);
    }

    @Override
    public Stock getStockByGood(Good good) {
        return stockDao.getStockByGood(good);
    }
}
