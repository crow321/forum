package test.dao;

import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

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
        user.setLocked(1);
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