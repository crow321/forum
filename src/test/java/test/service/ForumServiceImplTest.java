package test.service;

import com.jump.forum.entity.Topic;
import com.jump.forum.service.impl.ForumServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4;

import java.util.Date;

public class ForumServiceImplTest extends BaseJunit4 {
    @Autowired
    private ForumServiceImpl forumService;

    @Test
    public void testAddTopic() throws Exception {
        Topic topic = new Topic();
        topic.setCreateTime(new Date());
        topic.setDigest(0);
        topic.setLastPost(new Date());
        topic.setReplies(10);
        topic.setTopicTitle("test");
        topic.setViews(2);
        boolean result = forumService.addTopic(topic);
        System.out.println("add topic: " + result);
    }

    @Test
    public void testRemoveTopicById() throws Exception {

    }

    @Test
    public void testAddPost() throws Exception {

    }

    @Test
    public void testRemovePostById() throws Exception {

    }

    @Test
    public void testAddBoard() throws Exception {

    }

    @Test
    public void testRemoveBoardById() throws Exception {

    }

    @Test
    public void testMakeDigestTopic() throws Exception {

    }

    @Test
    public void testGetAllBoards() throws Exception {

    }

    @Test
    public void testGetPagedTopics() throws Exception {

    }

    @Test
    public void testGetPagedPosts() throws Exception {
//        forumService.getPagedPosts()
    }

    @Test
    public void testQueryTopicByTitle() throws Exception {

    }

    @Test
    public void testGetBoardById() throws Exception {

    }

    @Test
    public void testGetTopicByTopicId() throws Exception {

    }

    @Test
    public void testGetPostByPostId() throws Exception {

    }

    @Test
    public void testAddBoardManager() throws Exception {

    }

    @Test
    public void testUpdateTopic() throws Exception {

    }

    @Test
    public void testUpdatePost() throws Exception {

    }
}