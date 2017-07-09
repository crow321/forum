package test.dao;

import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.Board;
import com.jump.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.HashSet;
import java.util.Set;

public class UserDaoImplTest extends BaseJunit4 {
    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("testSaveUser");
        user.setPassword("123456");
        user.setUserType(1);
        user.setLastIp("101");
        user.setLocked(1);
        Set<Board> boardSet = new HashSet<>();
        Board board = new Board();
        board.setBoardName("board");
        boardSet.add(new Board());
        boolean result = userDao.save(user);
        System.out.println("save User: " + result);
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }
}