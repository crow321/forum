package com.jump.forum.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_topic")
public class Topic extends BaseDomain {
    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    @Column(name = "topic_title")
    private String topicTitle;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_post")
    private Date lastPost;

    private int views;
    private int replies;
    private int digest;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicTitle='" + topicTitle + '\'' +
                ", createTime=" + createTime +
                ", lastPost=" + lastPost +
                ", views=" + views +
                ", replies=" + replies +
                ", digest=" + digest +
                ", user=" + user +
                '}';
    }
}
