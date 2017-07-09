package test.dao;

import com.jump.forum.dao.impl.PostDaoImpl;
import com.jump.forum.dao.impl.TopicDaoImpl;
import com.jump.forum.dao.impl.UserDaoImpl;
import com.jump.forum.entity.MainPost;
import com.jump.forum.entity.Topic;
import com.jump.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.Date;

public class TopicDaoImplTest extends BaseJunit4 {
    @Autowired
    private TopicDaoImpl topicDao;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private PostDaoImpl postDao;

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        Topic topic = new Topic();
        topic.setBoardId(2);
        topic.setCreateTime(new Date());
        topic.setTopicId(10);

        User user = userDao.get(11);
        topic.setUser(user);

        MainPost mainPost = (MainPost) postDao.get(2);
        topic.setMainPost(mainPost);

        boolean res = topicDao.save(topic);
        System.out.println("save Topic: " + res);
    }

    @Test
    public void testDeleteById() throws Exception {

    }
}