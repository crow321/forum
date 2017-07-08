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

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
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
        return false;
    }

    /**
     * 增加回复帖子，用户积分+5，回复数+1，更新时间
     *
     * @param post
     * @return
     */
    @Override
    public boolean addPost(Post post) {
        LOGGER.debug("Receive addPost:{}", post);
        try {
            User postUser = post.getUser();
            postUser.setCredit(postUser.getCredit() + 5);
            userDao.update(postUser);

            Topic topic = post.getTopic();
            topic.setReplies(topic.getReplies() + 1);
            topic.setCreateTime(new Date());
            topicDao.update(topic);

            post.setCreateTime(new Date());
            postDao.save(post);
        } catch (Exception e) {
            LOGGER.error("addPost error in DAO, e:{}", e);
            return false;
        }
        LOGGER.debug("Response addPost:{}", SUCCESS);
        return true;
    }

    /**
     * 删除帖子，扣除创建该帖子的用户20积分，回复数-1
     * @param postId
     * @return
     */
    @Override
    public boolean removePostById(int postId) {
        try {
            Post post = postDao.get(postId);
            postDao.deleteById(postId);

            User user = post.getUser();
            user.setCredit(user.getCredit() - 20);
            userDao.update(user);

            Topic topic = post.getTopic();
            topic.setReplies(topic.getReplies() - 1);
            topicDao.update(topic);
        } catch (Exception e) {
            LOGGER.error("removePostById DAO error");
            return false;
        }
        return false;
    }

    /**
     * 创建一个新的论坛版块
     * @param board
     * @return
     */
    @Override
    public boolean addBoard(Board board) {
        LOGGER.debug("Receive addBoard:{}", board);
        try {
            boardDao.save(board);
        } catch (Exception e) {
            LOGGER.error("addBoard DAO error:{}", e);
            return false;
        }
        LOGGER.debug("Response addBoard:{}", SUCCESS);
        return true;
    }

    /**
     * 删除版块
     * @param boardId
     * @return
     */
    @Override
    public boolean removeBoardById(int boardId) {
        LOGGER.debug("Receive removeBoardById:{}", boardId);
        try {
            boardDao.deleteById(boardId);
        } catch (Exception e) {
            LOGGER.error("removeBoardById DAO error:{}", e);
            return false;
        }
        LOGGER.debug("Response removeBoardById:{}", SUCCESS);
        return true;
    }

    /**
     * 设置精华帖
     * 1）设置帖子级别 1/2/3  2)用户积分+100
     * @param topicId
     * @return
     */
    @Override
    public boolean makeDigestTopic(int topicId) {
        LOGGER.debug("Receive makeDigestTopic:{}", topicId);
        try {
            Topic topic = topicDao.get(topicId);
            topic.setDigest(Topic.DIGEST_TOPIC);
            topicDao.update(topic);

            User user = topic.getUser();
            user.setCredit(user.getCredit() + 100);
            userDao.update(user);
        } catch (Exception e) {
            LOGGER.error("makeDigestTopic DAO error:{}", e);
            return false;
        }
        LOGGER.debug("Response makeDigestTopic:{}", SUCCESS);
        return true;
    }

    @Override
    public List<Board> getAllBoards() {
        //todo
        return null;
    }

    @Override
    public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
        LOGGER.debug("Receive getPagedTopics:boardId:{},pageNo:{},PageSize:{}", boardId, pageNo, pageSize);
        return topicDao.getPagedTopics(boardId, pageNo, pageSize);
    }

    @Override
    public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
        LOGGER.debug("Receive getPagedPosts, topicId:{},pageNo:{},PageSize:{}", topicId, pageNo, pageSize);
        return postDao.queryFoPage(topicId, pageNo, pageSize);
    }

    @Override
    public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
        LOGGER.debug("Receive getPagedTopics, title:{},pageNo:{},PageSize:{}", title, pageNo, pageSize);
        return topicDao.queryTopicByTitle(title, pageNo, pageSize);
    }

    @Override
    public Board getBoardById(int boardId) {
        LOGGER.debug("Receive getBoardById, boardId:{}", boardId);
        return boardDao.get(boardId);
    }

    @Override
    public Topic getTopicByTopicId(int topicId) {
        LOGGER.debug("Receive getTopicByTopicId, topicId:{}", topicId);
        return topicDao.get(topicId);
    }

    @Override
    public Post getPostByPostId(int postId) {
        LOGGER.debug("Receive getPostByPostId, postId:{}", postId);
        return postDao.get(postId);
    }

    /**
     * 将用户提升为论坛版块的管理员
     * @param boardId
     * @param userName
     * @return
     */
    @Override
    public boolean addBoardManager(int boardId, String userName) {
        LOGGER.debug("Receive addBoardManager, boardId:{},userName:{}", boardId, userName);
        User user = userDao.getUserByUserName(userName);
        if (user == null) {
            LOGGER.warn("用户名为:{}的用户不存在！", userName);
            return false;
        } else {
            Board board = boardDao.get(boardId);
            user.getManBoards().add(board);
            userDao.update(user);
        }
        LOGGER.debug("Response addBoardManager:{}", SUCCESS);
        return true;
    }

    @Override
    public boolean updateTopic(Topic topic) {
        LOGGER.debug("Receive updateTopic:{}", topic);
        return topicDao.update(topic);
    }

    @Override
    public boolean updatePost(Post post) {
        LOGGER.debug("Receive updatePost:{}", post);
        return postDao.update(post);
    }
}
