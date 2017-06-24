package com.jump.forum.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_board")
public class Board extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;
    @Column(name = "board_name")
    private String boardName;
    @Column(name = "board_desc")
    private String boardDesc;
    @Column(name = "topic_num")
    private int topicNumber;
    @Column(name = "main_topic")
    private MainPost mainPost;

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc;
    }

    public int getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(int topicNumber) {
        this.topicNumber = topicNumber;
    }

    public MainPost getMainPost() {
        return mainPost;
    }

    public void setMainPost(MainPost mainPost) {
        this.mainPost = mainPost;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", boardDesc='" + boardDesc + '\'' +
                ", topicNumber=" + topicNumber +
                ", mainPost=" + mainPost +
                '}';
    }
}
