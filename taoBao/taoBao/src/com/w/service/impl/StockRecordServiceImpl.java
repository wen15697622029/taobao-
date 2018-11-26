package com.w.service.impl;

import com.w.dao.StockRecordDao;
import com.w.model.StockRecord;
import com.w.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Service
public class StockRecordServiceImpl implements StockRecordService {
    @Autowired
    private StockRecordDao stockRecordDao = null;

    @Override
    public boolean addStockRecord(StockRecord stockRecord) {
        return stockRecordDao.addStockRecord(stockRecord);
    }

    @Override
    public List<StockRecord> getStockRecord() {
        return stockRecordDao.getStockRecord();
    }

    @Override
    public List<StockRecord> queryCurrentPageStockRecord(int currentPage, int pageSize) {
        List<StockRecord> stockRecords = getStockRecord();
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<StockRecord> stockRecordList = new ArrayList<>();
        for (int i = begin; !stockRecords.isEmpty()&&(i<begin+end)&&i <stockRecords.size() ; i++) {
            stockRecordList.add(stockRecords.get(i));
        }
        return stockRecordList;
    }
}
