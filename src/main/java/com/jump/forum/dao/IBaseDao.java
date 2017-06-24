package com.jump.forum.dao;

import com.jump.forum.vo.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IBaseDao<T> {

    //根据id加载实例
    public T load(Serializable id);

    //根据ID获取实例
    public T get(Serializable id);

    //加载所有实例
    public List<T> loadAll();

    //保存
    public boolean save(T entity);

    //删除
    public boolean remove(T entity);

    //更新
    public boolean update(T entity);

    //根据hql语句查询
    public List<T> find(String hql);

    //执行带参数的hql语句
    public List<T> find(String hql, Object... params);

    //对延迟加载的实体进行初始化
    public boolean initialize(Object entity);

    //分页
    public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values);
}
