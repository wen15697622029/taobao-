package com.w.service;

import com.w.model.User;
import com.w.model.UserDetail;

import java.util.List;

/**
 * Created by destiny on 2018/7/5/0005.
 */
public interface UserDetailService {

    List<UserDetail> getUserDetailByUser(User user);

    List<UserDetail> queryCurrentPageUserDetailByUser(User user, int currentPage, int pageSize);

    boolean addUserDetail(UserDetail userDetail);

    boolean deleteUserDetail(UserDetail userDetail);

    boolean updateUserDetail(UserDetail userDetail);

    UserDetail getUserDetailById(UserDetail userDetail);
}
