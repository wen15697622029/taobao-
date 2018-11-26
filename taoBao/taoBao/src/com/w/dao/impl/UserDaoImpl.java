package com.w.dao.impl;

import com.w.dao.UserDao;
import com.w.model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public User getUserByName(User user) {
        String hql = "from User where name = ?";
        List<User> users = (List<User>) hibernateTemplate.find(hql,user.getName());
        if (users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public boolean updateUser(User user) {
        hibernateTemplate.update(user);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        hibernateTemplate.save(user);
        return true;
    }
}
