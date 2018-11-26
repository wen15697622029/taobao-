package com.w.dao;

import com.w.model.User;
import com.w.model.UserDetail;

import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
public interface UserDetailDao {
    List<UserDetail> getUserDetailByUser(User user);

    boolean addUserDetail(UserDetail userDetail);

    UserDetail getUserDetailById(UserDetail userDetail);

    boolean deleteUserDetail(UserDetail userDetail);

    boolean updateUserDetail(UserDetail userDetail);
}
