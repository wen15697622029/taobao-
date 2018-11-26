package com.w.dao.impl;

import com.w.dao.StockRecordDao;
import com.w.model.StockRecord;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Repository
public class StockRecordDaoImpl implements StockRecordDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean addStockRecord(StockRecord stockRecord) {
        hibernateTemplate.save(stockRecord);
        return true;
    }

    @Override
    public List<StockRecord> getStockRecord() {
        String hql = "from StockRecord";
        List<StockRecord> stockRecords = (List<StockRecord>) hibernateTemplate.find(hql);
        return stockRecords;
    }
}
