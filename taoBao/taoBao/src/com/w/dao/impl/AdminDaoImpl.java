package com.w.dao.impl;

import com.w.dao.AdminDao;
import com.w.model.Admin;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Repository
public class AdminDaoImpl implements AdminDao{
    @Resource
    private HibernateTemplate hibernateTemplate;
    @Override
    public Admin getAdminByName(Admin admin) {
        String hql = "from Admin where name=?";
        List<Admin> admins = (List<Admin>) hibernateTemplate.find(hql,admin.getName());
        if (admins.isEmpty()){
            return null;
        }
        return admins.get(0);
    }
}
