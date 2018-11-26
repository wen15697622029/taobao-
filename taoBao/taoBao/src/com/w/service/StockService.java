package com.w.service;

import com.w.model.Good;
import com.w.model.Stock;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public interface StockService {

    boolean updateStock(Stock stock);

    Stock getStockByGood(Good good);
}
