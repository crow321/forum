package test.dao;

import com.jump.forum.dao.impl.BoardDaoImpl;
import com.jump.forum.entity.Board;
import com.jump.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.List;

public class BoardDaoImplTest extends BaseJunit4 {
    @Autowired
    private BoardDaoImpl boardDao;

    //1
    @Test
    public void testGetBoardNum() throws Exception {
        Long count = boardDao.getBoardNum();
        System.out.println("get boardNum:" + count);
    }

    //todo
    @Test
    public void testLoad() throws Exception {
        Board board = boardDao.load(15);
        System.out.println("test load Board: " + board);

    }

    //1
    @Test
    public void testGet() throws Exception {
        Board board = boardDao.get(15);
        System.out.println("get Board: " + board);
    }

    //todo
    @Test
    public void testLoadAll() throws Exception {

    }

    //1
    @Test
    public void testSave() throws Exception {
        for (int i = 0; i < 3; i++) {
            Board board = new Board();
            board.setBoardName("testSave" + i);
            board.setBoardDesc("test");
            board.setTopicNumber(i);

            User user = new User();
            user.setUserName("postUser" + i);
            board.setUser(user);

          /*  MainPost mainPost = new MainPost();
            mainPost.setPostTitle("mainPost");
            board.setMainPost(mainPost);*/

            boolean result = boardDao.save(board);
            System.out.println("save Board -->" + result);
        }
    }

    //1
    @Test
    public void testRemove() throws Exception {
        Board board = boardDao.get(15);
        boolean result = boardDao.remove(board);
        System.out.println("remove Board: " + result);
    }

    //1
    @Test
    public void testDeleteById() throws Exception {
        boolean result = boardDao.deleteById(16);
        System.out.println("remove Board: " + result);
    }

    //1
    @Test
    public void testUpdate() throws Exception {
        Board board = boardDao.get(20);
        board.setBoardDesc("update1");
        board.setTopicNumber(201);
        boolean result = boardDao.update(board);
        System.out.println("update Board -->" + result);
    }

    @Test
    public void testFind() throws Exception {
        String hql = "select b from Board b where b.id=21";
        List<Board> list = boardDao.find(hql);
        System.out.println(list.toString());
    }

    @Test
    public void testFind1() throws Exception {
        //todo
    }

    @Test
    public void testPagedQuery() throws Exception {
        //todo
    }
}