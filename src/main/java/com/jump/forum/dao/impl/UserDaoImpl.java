package com.jump.forum.dao.impl;

import com.jump.forum.dao.IUserDao;
import com.jump.forum.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao<User> {

    @Override
    public User getUserByUserName(String userName) {
        String hql = "select user from User user where user.userName=:userName";
        Query query = getSession().createQuery(hql);
        query.setParameter("userName", userName);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> queryUserByUserName(String userName) {
        //todo
        return null;
    }
}
