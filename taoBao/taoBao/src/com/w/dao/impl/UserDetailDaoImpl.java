package com.w.dao.impl;

import com.w.dao.UserDetailDao;
import com.w.model.User;
import com.w.model.UserDetail;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
@Repository
public class UserDetailDaoImpl implements UserDetailDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<UserDetail> getUserDetailByUser(User user) {
        String hql = "from UserDetail where user.id = ?";
        List<UserDetail> userDetails = (List<UserDetail>) hibernateTemplate.find(hql,user.getId());
        return userDetails;
    }

    @Override
    public boolean addUserDetail(UserDetail userDetail) {
        hibernateTemplate.save(userDetail);
        return true;
    }

    @Override
    public UserDetail getUserDetailById(UserDetail userDetail) {
        String hql = "from UserDetail where id = ?";
        List<UserDetail> userDetails = (List<UserDetail>) hibernateTemplate.find(hql,userDetail.getId());
        if (userDetails.isEmpty()){
            return null;
        }
        return userDetails.get(0);
    }

    @Override
    public boolean deleteUserDetail(UserDetail userDetail) {
        hibernateTemplate.delete(userDetail);
        return true;
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        hibernateTemplate.update(userDetail);
        return true;
    }
}
