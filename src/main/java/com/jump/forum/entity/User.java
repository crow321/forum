package com.jump.forum.entity;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/23.
 */
public class User extends BaseDomain {
    private int userId;
    private String userName;
    private String password;
    private long userType;
    private long locked;
    private int oredit;
    private Date lastVisit;
    private String lastip;
    private Set manBoards;

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

    public int getOredit() {
        return oredit;
    }

    public void setOredit(int oredit) {
        this.oredit = oredit;
    }

    public Date getLastVisit() {
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
    }
}
