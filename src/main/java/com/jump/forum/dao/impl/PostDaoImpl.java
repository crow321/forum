package com.jump.forum.dao.impl;

import com.jump.forum.dao.IPostDao;
import com.jump.forum.entity.Post;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class PostDaoImpl extends BaseDaoImpl<Post> implements IPostDao<Post> {

    @Override
    public boolean deleteTopicPostsById(int id) {
        String hql = "delete Post where ";
        Query query = getSession().createQuery(hql);

        return false;
    }
}
