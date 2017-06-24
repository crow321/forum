package com.jump.forum.service.impl;

import com.jump.forum.dao.impl.BoardDaoImpl;
import com.jump.forum.dao.impl.PostDaoImpl;
import com.jump.forum.dao.impl.TopicDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.*;
import com.jump.forum.service.IForumService;
import com.jump.forum.vo.Page;
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
public class ForumServiceImpl implements IForumService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForumServiceImpl.class);
    @Autowired
    private BoardDaoImpl boardDao;
    @Autowired
    private PostDaoImpl postDao;
    @Autowired
    private TopicDaoImpl topicDao;
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public boolean addTopic(Topic topic) {
        Board board = boardDao.get(topic.getBoardId());
        board.setTopicNumber(board.getTopicNumber() + 1);

        //1. 创建主题帖子
        MainPost post = topic.getMainPost();
        post.setTopic(topic);
        post.setBoardId(topic.getBoardId());
        post.setCreateTime(new Date());
        post.setPostTitle(topic.getTopicTitle());
        post.setUser(topic.getUser());

        // 2.持久化主题帖
        postDao.save(post);

        //3.更新用户积分
        User user = topic.getUser();
        user.setCredit(user.getCredit() + 10);
        userDao.update(user);
        return true;
    }

    /**
     * 删除一个主题帖
     *
     * @param topicId
     * @return 1.用户积分减50 2）论坛版块主题帖数减1 3）删除主题帖所有关联的帖子
     */
    @Override
    public boolean removeTopicById(int topicId) {
        Topic topic = topicDao.get(topicId);
        Board board = boardDao.get(topic.getBoardId());
        board.setTopicNumber(board.getTopicNumber() - 1);
        boardDao.update(board);

        User user = topic.getUser();
        user.setCredit(user.getCredit() - 50);
        userDao.update(user);

        topicDao.remove(topic);
        postDao.
        return false;
    }

    @Override
    public boolean addPost(Post post) {
        return false;
    }

    @Override
    public boolean removePostById(int postId) {
        return false;
    }

    @Override
    public boolean addBoard(Board board) {
        return false;
    }

    @Override
    public boolean removeBoardById(int boardId) {
        return false;
    }

    @Override
    public boolean makeDigestTopic(int topicId) {
        return false;
    }

    @Override
    public List<Board> getAllBoards() {
        return null;
    }

    @Override
    public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page getPagedPosts(int postId, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Board getBoardById(int boardId) {
        return null;
    }

    @Override
    public Topic getTopicByTopicId(int topicId) {
        return null;
    }

    @Override
    public Post getPostByPostId(int postId) {
        return null;
    }

    @Override
    public boolean addBoardManager(int boardId, String userName) {
        return false;
    }

    @Override
    public boolean updateTopic(Topic topic) {
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        return false;
    }
}
