package com.jump.forum.dao.impl;

import com.jump.forum.dao.IBoardDao;
import com.jump.forum.entity.Board;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class BoardDaoImpl extends BaseDaoImpl<Board> implements IBoardDao<Board> {
    protected final String GET_BOARD_NUM = "select count(b.boardId) from Board as b";


    /**
     * 获取论坛版块数量
     *
     * @return
     */
    @Override
    public Long getBoardNum() {
        Query query = getSession().createQuery(GET_BOARD_NUM);
        return (Long) query.uniqueResult();
    }
}
