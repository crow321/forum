package com.jump.forum.dao.impl;

import com.jump.forum.dao.IBaseDao;
import com.jump.forum.vo.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基类Dao
 * Created by Administrator on 2017/6/23.
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> clazz;

    /**
     * 通过反射获取子类确定的泛型类
     */
    public BaseDaoImpl() {
        ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types = pType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }

    /**
     * 去吃hql中的select子句
     *
     * @param hql
     * @return
     */
    private static String removeSelect(String hql) {
        if (hql == null || hql.equals("")) {
            LOGGER.error("hql查询语句为空...");
            return null;
        }
        int beginPos = hql.toLowerCase().indexOf("from");
        if (beginPos != -1) {
            return hql.substring(beginPos);
        } else
            LOGGER.info("hql中不含select子句...");
        return hql;
    }

    /**
     * 去掉hql中的 orderBy 子句
     *
     * @param hql
     * @return
     */
    private static String removeOrders(String hql) {
        if (hql == null || hql.equals("")) {
            LOGGER.error("hql查询语句为空...");
            return null;
        }
        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hql);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    @Override
    public T load(int id) {
        return getSession().load(clazz, id);
    }

    @Override
    public T get(int id) {
        return getSession().get(clazz, id);
    }

    @Override
    public List<T> loadAll() {
        //todo
        return null;
    }

    @Override
    public boolean save(T entity) {
        getSession().save(entity);
        return true;
    }

    @Override
    public boolean remove(T entity) {
        getSession().remove(entity);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        String hql = "delete " + clazz.getSimpleName() + " where " + clazz.getSimpleName().toLowerCase() + "Id=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }

    @Override
    public boolean update(T entity) {
        getSession().update(entity);
        return true;
    }

    @Override
    public List<T> find(String hql) {
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> find(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    /**
     * 分页查询
     *
     * @param hql
     * @param pageNo
     * @param pageSize
     * @param values
     * @return
     */
    @Override
    public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
        //todo
        if (hql == null || hql.equals("")) {
            return null;
        }
        if (pageNo < 1) {
            LOGGER.error("pageNo should start from 1...");
            return null;
        }
        //count查询
        String countQueryHql = "select count(*)" + removeSelect(hql);
        Query query = createQuery(countQueryHql, values);
        List countList = query.list();
        long totalCount = (Long) countList.get(0);
        //实际查询返回分页对象
        if (totalCount < 1) {
            return new Page();
        }
        int startIndex = Page.getStartOfPage(pageNo, pageSize);
        query = createQuery(hql, values);
        List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
        return new Page(startIndex, totalCount, pageSize, list);
    }

    /**
     * 创建query对象
     *
     * @param hql
     * @param values
     * @return
     */
    protected Query createQuery(String hql, Object... values) {
        if (hql == null || hql.equals("")) {
            LOGGER.error("hql查询语句为空...");
            return null;
        }
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    @Override
    public boolean initialize(Object entity) {
        //todo
        return false;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
