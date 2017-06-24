package com.jump.forum.dao;


import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IUserDao<User> extends IBaseDao<User> {
    public User getUserByUserName(String userName);

    /**
     * 根据用户名为条件，进行模糊查询
     *
     * @param userName
     * @return
     */
    public List<User> queryUserByUserName(String userName);
}
