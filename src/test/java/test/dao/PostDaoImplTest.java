package test.dao;

import com.jump.forum.dao.impl.PostDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.Post;
import com.jump.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.Date;

public class PostDaoImplTest extends BaseJunit4 {
    @Autowired
    private PostDaoImpl postDao;
    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void testSave() throws Exception {
        Post post = new Post();
//        post.setPostId(101);
        post.setCreateTime(new Date());
        post.setBoardId(10);
        post.setPostText("text");
        post.setPostTitle("postTitle");
        User user = userDao.get(11);
        post.setUser(user);
        boolean result = postDao.save(post);
        System.out.println("savePost: " + result);
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testPagedQuery() throws Exception {

    }
}