package com.w.dao.impl;

import com.w.dao.RealStockDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Repository
public class RealStockDaoImpl implements RealStockDao{
    @Resource
    private HibernateTemplate hibernateTemplate;
}
