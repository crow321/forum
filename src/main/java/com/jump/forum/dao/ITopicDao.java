package com.jump.forum.dao;

import com.jump.forum.vo.Page;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface ITopicDao<Topic> extends IBaseDao<Topic> {
    //获取论坛版块某一页的精华主题帖，按最后回复时间及精华级别降序排序
    public Page getBoardDigestTopics(int boardId, int pageNo, int pageSize);

    //获取论坛版块某一页的主题帖
    public Page getPagedTopics(int boardId, int pageNo, int pageSize);

    //获取和主题帖标题模糊匹配的主题帖（某一页数据）
    public Page queryTopicByTitle(String title, int pageNo, int pageSize);
}
