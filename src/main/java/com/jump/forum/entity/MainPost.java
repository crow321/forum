package com.jump.forum.entity;

import javax.persistence.*;

/**
 * 主题帖子类
 * Created by Administrator on 2017/6/23.
 */
@Entity
@Table(name = "t_post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("2")
public class MainPost extends Post {

}
