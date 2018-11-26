package com.w.service.impl;

import com.w.dao.UserDao;
import com.w.model.User;
import com.w.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao = null;

    @Override
    public User getUserByName(User user) {
        return userDao.getUserByName(user);
    }

    @Override
    public int userLogin(User user) {
        User user1 = userDao.getUserByName(user);
        if (user1==null){
            return 0;
        }else if (user1.getPass().equals(user.getPass())){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public User updateChongZhi(User user, Double money) {
        user.setMoney(user.getMoney()+money);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public boolean updatePassWord(User user, String oldPassWord, String newPassWord) {
        if (!oldPassWord.equals(user.getPass())){
            return false;
        }
        user.setPass(newPassWord);
        userDao.updateUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        User user1 = getUserByName(user);
        user1.setMoney(user.getMoney());
        return userDao.updateUser(user1);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
