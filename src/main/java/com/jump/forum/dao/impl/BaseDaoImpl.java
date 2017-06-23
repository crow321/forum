package com.jump.forum.dao.impl;

import com.jump.forum.dao.IBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {

    @Override
    public T load() {
        return null;
    }

    @Override
    public List<T> loadAll() {
        return null;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public List<T> find(String hql) {
        return null;
    }

    @Override
    public void update(T entity) {

    }
}
