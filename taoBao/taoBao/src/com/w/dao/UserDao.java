package com.w.dao;

import com.w.model.User;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public interface UserDao {
    User getUserByName(User user);

    boolean updateUser(User user);

    boolean addUser(User user);
}
