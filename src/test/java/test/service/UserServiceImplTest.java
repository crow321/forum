package test.service;

import com.jump.forum.dao.impl.LoginLogDaoImpl;
import com.jump.forum.entity.User;
import com.jump.forum.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

public class UserServiceImplTest extends BaseJunit4 {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private LoginLogDaoImpl logDao;

    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("testRegister");
        user.setPassword("123456");
        user.setUserType(1);
        user.setLocked(1);
        boolean result = userService.register(user);
        System.out.println("register: " + result);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGetUserByUserName() throws Exception {

    }

    @Test
    public void testGetUserById() throws Exception {

    }

    @Test
    public void testLockUser() throws Exception {

    }

    @Test
    public void testUnlockUser() throws Exception {

    }

    @Test
    public void testQueryUserByUserName() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testLoginSuccess() throws Exception {
        User user = userService.getUserByUserName("testRegister");
        userService.loginSuccess(user);
    }
}