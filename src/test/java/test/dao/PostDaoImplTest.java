package test.dao;

import com.jump.forum.dao.impl.PostDaoImpl;
import com.jump.forum.entity.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.Date;

public class PostDaoImplTest extends BaseJunit4 {
    @Autowired
    private PostDaoImpl postDao;

    @Test
    public void testSave() throws Exception {
        Post post = new Post();
        post.setCreateTime(new Date());
        post.setPostId(100);
        post.setBoardId(10);
        post.setPostText("text");
        post.setPostTitle("postTitle");
        post.setPostType(2);

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