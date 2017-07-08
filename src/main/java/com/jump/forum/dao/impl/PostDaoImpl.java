package com.jump.forum.dao.impl;

import com.jump.forum.dao.IPostDao;
import com.jump.forum.entity.Post;
import com.jump.forum.vo.Page;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class PostDaoImpl extends BaseDaoImpl<Post> implements IPostDao<Post> {

    @Override
    public boolean deleteTopicPostsById(int id) {
        String hql = "delete Post where postId=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        return query.executeUpdate() > 0;
    }

    @Override
    public Page queryFoPage(int postId, int pageNo, int pageSize) {
        String hql = "select p from Post as p where p.postId=:id";
        Query query = getSession().createQuery(hql);
        List<Post> list = query.list();
        if (list != null) {
            int totalCount = list.size();
            int startIndex = Page.getStartOfPage(pageNo, pageSize);
            return new Page(startIndex, totalCount, pageSize, list);
        }
        return new Page();
    }
}
