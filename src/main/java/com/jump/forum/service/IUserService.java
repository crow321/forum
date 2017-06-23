package com.jump.forum.service;

import com.jump.forum.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IUserService {
    boolean register(User user);

    boolean update(User user);

    User getUserByUserName(String userName);

    User getUserById(int userId);

    boolean lockUser(String userName);

    boolean unlockUser(String userName);

    List<User> queryUserByUserName(String userName);

    List<User> getAllUsers();

    boolean loginSuccess(User user);
}
