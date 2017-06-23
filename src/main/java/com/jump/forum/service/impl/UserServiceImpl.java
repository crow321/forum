package com.jump.forum.service.impl;

import com.jump.forum.dao.impl.LoginLogDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.User;
import com.jump.forum.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private LoginLogDaoImpl loginLogDao;

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public boolean lockUser(String userName) {
        return false;
    }

    @Override
    public boolean unlockUser(String userName) {
        return false;
    }

    @Override
    public List<User> queryUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean loginSuccess(User user) {
        return false;
    }
}
