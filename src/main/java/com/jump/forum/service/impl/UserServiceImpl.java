package com.jump.forum.service.impl;

import com.jump.forum.dao.IUserDao;
import com.jump.forum.dao.impl.LoginLogDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.LoginLog;
import com.jump.forum.entity.User;
import com.jump.forum.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        User u = this.getUserByUserName(user.getUserName());
        if (u != null) {
            LOGGER.error("该用户已存在...");
            return false;
        }
        user.setCredit(100);
        user.setUserType(1);
        return userDao.save(user);
    }

    @Override
    public boolean update(User user) {
        User u = this.getUserByUserName(user.getUserName());
        if (u == null) {
            LOGGER.error("用户不存在...");
            return false;
        }
        return userDao.update(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.get(userId);
    }

    @Override
    public boolean lockUser(String userName) {
        User user = getUserByUserName(userName);
        if (user == null) {
            LOGGER.error("用户不存在...");
            return false;
        }
        if (user.getLocked() == 1) {
            LOGGER.warn("用户已被锁定...");
            return true;
        }
        user.setLocked(User.USER_LOCK);
        return userDao.update(user);
    }

    @Override
    public boolean unlockUser(String userName) {
        User user = getUserByUserName(userName);
        if (user == null) {
            LOGGER.error("用户不存在...");
            return false;
        }
        if (user.getLocked() == 0) {
            LOGGER.warn("用户未被锁定...");
            return false;
        }
        user.setLocked(User.USER_UNLOCK);
        return userDao.update(user);
    }

    @Override
    public List<User> queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.loadAll();
    }

    @Override
    public boolean loginSuccess(User user) {
        user.setCredit(5 + user.getCredit());
        LoginLog log = new LoginLog();
        log.setIp(user.getLastIp());
        log.setLoginDate(new Date());
        log.setUser(user);
        loginLogDao.save(log);
        userDao.update(user);
        return true;
    }
}
