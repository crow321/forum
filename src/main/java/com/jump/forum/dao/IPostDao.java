package com.jump.forum.dao;

import com.jump.forum.vo.Page;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IPostDao<Post> extends IBaseDao<Post> {
    public boolean deleteTopicPostsById(int id);

    public Page queryFoPage(int postId, int pageNo, int pageSize);
}
