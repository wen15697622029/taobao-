package com.w.service.impl;

import com.w.dao.AdminDao;
import com.w.model.Admin;
import com.w.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao = null;

    @Override
    public int adminLogin(Admin admin) {
        Admin admin1 = adminDao.getAdminByName(admin);
        if (admin1==null){
            return 0;
        }else if (admin.getPassword().equals(admin1.getPassword())){
            return 1;
        }else {
            return 2;
        }
    }
}
