package com.w.service.impl;

import com.w.dao.UserDetailDao;
import com.w.model.User;
import com.w.model.UserDetail;
import com.w.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
@Service
public class UserDetailServiceImpl implements UserDetailService{
    @Autowired
    private UserDetailDao userDetailDao = null;

    @Override
    public List<UserDetail> getUserDetailByUser(User user) {
        return userDetailDao.getUserDetailByUser(user);
    }

    @Override
    public List<UserDetail> queryCurrentPageUserDetailByUser(User user, int currentPage, int pageSize) {
        List<UserDetail> userDetails = getUserDetailByUser(user);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<UserDetail> userDetailList = new ArrayList<>();
        for (int i = begin; (i<begin+end)&&i <userDetails.size() ; i++) {
            userDetailList.add(userDetails.get(i));
        }
        return userDetailList;
    }

    @Override
    public boolean addUserDetail(UserDetail userDetail) {
        return userDetailDao.addUserDetail(userDetail);
    }

    @Override
    public boolean deleteUserDetail(UserDetail userDetail) {
        UserDetail userDetail1 = getUserDetailById(userDetail);
        if (userDetail1==null){
            return false;
        }
        if (userDetail1.getOrders().isEmpty()){
            return userDetailDao.deleteUserDetail(userDetail1);
        }
        return false;
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return userDetailDao.updateUserDetail(userDetail);
    }

    public UserDetail getUserDetailById(UserDetail userDetail) {
        return userDetailDao.getUserDetailById(userDetail);
    }
}
