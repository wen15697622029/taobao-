package com.w.service;

import com.w.model.StockRecord;

import java.util.List;

/**
 * Created by destiny on 2018/7/8/0008.
 */
public interface StockRecordService {

    boolean addStockRecord(StockRecord stockRecord);

    List<StockRecord> getStockRecord();

    List<StockRecord> queryCurrentPageStockRecord(int currentPage, int pageSize);
}
