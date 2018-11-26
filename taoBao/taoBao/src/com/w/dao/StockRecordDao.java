package com.w.dao;

import com.w.model.StockRecord;

import java.util.List;

/**
 * Created by destiny on 2018/7/8/0008.
 */
public interface StockRecordDao {

    boolean addStockRecord(StockRecord stockRecord);

    List<StockRecord> getStockRecord();
}
