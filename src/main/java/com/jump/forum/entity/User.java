package com.jump.forum.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_user")
public class User extends BaseDomain {
    public static final int USER_LOCK = 1;//1表示用户被锁定
    public static final int USER_UNLOCK = 0;//0 表示用户未被锁定

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "user_type")
    private long userType;
    @Column(name = "locked")
    private long locked;
    @Column(name = "credit")
    private int credit;
    //    private Date lastVisit;
    @Column(name = "last_ip")
    private String lastIp;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Board> manBoards;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Post> postSet;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Topic> topicSet;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public long getLocked() {
        return locked;
    }

    public void setLocked(long locked) {
        this.locked = locked;
    }

    /*public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public Set getManBoards() {
        return manBoards;
    }

    public void setManBoards(Set manBoards) {
        this.manBoards = manBoards;
    }*/

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Set getManBoards() {
        return manBoards;
    }

    public void setManBoards(Set manBoards) {
        this.manBoards = manBoards;
    }

    /*public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }*/
}
