package com.jump.forum.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_user")
public class User extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "user_type")
    private long userType;
    private long locked;
    private int credit;
    /*private Date lastVisit;
    private String lastip;
    private Set manBoards;*/

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
}
