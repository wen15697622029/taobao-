package com.w.service;

import com.w.model.User;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public interface UserService {
    User getUserByName(User user);
    int userLogin(User user);

    User updateChongZhi(User user, Double money);

    boolean updatePassWord(User user, String oldPassWord, String newPassWord);

    boolean updateUser(User user);

    boolean addUser(User user);
}
