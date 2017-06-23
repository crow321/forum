package com.jump.forum.service.impl;

import com.jump.forum.dao.impl.BoardDaoImpl;
import com.jump.forum.dao.impl.PostDaoImpl;
import com.jump.forum.dao.impl.TopicDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.Board;
import com.jump.forum.entity.Post;
import com.jump.forum.entity.Topic;
import com.jump.forum.service.IForumService;
import com.jump.forum.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return false;
    }

    @Override
    public boolean removeTopicById(int topicId) {
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
