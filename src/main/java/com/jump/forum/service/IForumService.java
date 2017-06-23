package com.jump.forum.service;

import com.jump.forum.entity.Board;
import com.jump.forum.entity.Post;
import com.jump.forum.entity.Topic;
import com.jump.forum.vo.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IForumService {
    boolean addTopic(Topic topic);

    boolean removeTopicById(int topicId);

    boolean addPost(Post post);

    boolean removePostById(int postId);

    boolean addBoard(Board board);

    boolean removeBoardById(int boardId);

    boolean makeDigestTopic(int topicId);

    List<Board> getAllBoards();

    Page getPagedTopics(int boardId, int pageNo, int pageSize);

    Page getPagedPosts(int postId, int pageNo, int pageSize);

    Page queryTopicByTitle(String title, int pageNo, int pageSize);

    Board getBoardById(int boardId);

    Topic getTopicByTopicId(int topicId);

    Post getPostByPostId(int postId);

    boolean addBoardManager(int boardId, String userName);

    boolean updateTopic(Topic topic);

    boolean updatePost(Post post);
}
