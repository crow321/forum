package com.jump.forum.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_post")
//指定 POJO 的映射继承关系，这里是每个类层次结构一张表
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//定义辨别类型 字符串
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
//定义辨别该类的值为 1
@DiscriminatorValue("1")
public class Post extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "board_id")
    private int boardId;
    @Column(name = "post_type")
    private int postType;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_text")
    private String postText;
    @Column(name = "create_time")
    private Date createTime;

    //多对一关系
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", boardId=" + boardId +
                ", postType=" + postType +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", createTime=" + createTime +
                ", user=" + user +
                ", topic=" + topic +
                '}';
    }
}
