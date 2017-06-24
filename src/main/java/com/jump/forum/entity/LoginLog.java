package com.jump.forum.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_login_log")
public class LoginLog extends BaseDomain {
    @Id
    @Column(name = "login_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginLogId;

    private String ip;
    @Column(name = "login_date_time")
    private String loginDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "loginLogId=" + loginLogId +
                ", ip='" + ip + '\'' +
                ", loginDate='" + loginDate + '\'' +
                ", user=" + user +
                '}';
    }
}
