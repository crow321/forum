package com.jump.forum.dao.impl;

import com.jump.forum.dao.ITopicDao;
import com.jump.forum.entity.Topic;
import com.jump.forum.vo.Page;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao<Topic> {
    //todo
    @Override
    public Page getBoardDigestTopics(int boardId, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
        return null;
    }
}
