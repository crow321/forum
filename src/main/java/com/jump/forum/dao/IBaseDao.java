package com.jump.forum.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IBaseDao<T> {
    public T load();

    public List<T> loadAll();

    public T get();

    public List<T> find(String hql);

    public void update(T entity);
}
