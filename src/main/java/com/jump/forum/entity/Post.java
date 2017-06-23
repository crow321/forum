package com.jump.forum.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Post extends BaseDomain {
    private int postId;
    private int topicId;
    private int postType;
    private String postTitls;
    private String postText;
    private Date createTime;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public String getPostTitls() {
        return postTitls;
    }

    public void setPostTitls(String postTitls) {
        this.postTitls = postTitls;
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
}
