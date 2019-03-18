package pl.slusarski.taskapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.slusarski.taskapp.entity.Task;
import pl.slusarski.taskapp.entity.User;
import pl.slusarski.taskapp.service.TaskService;
import pl.slusarski.taskapp.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAppApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testUser@mail.com", "testUser", "test");
            userService.createUser(newUser);
        }

        {
            User newUser = new User("testAdmin@mail.com", "testAdmin", "test");
            userService.createUser(newUser);
        }

        Task task = new Task("03/01/2018", "07:00", "11:00", "description");
        User user = userService.findUser("testUser@mail.com");
        taskService.addTask(task, user);
    }

    @Test
    public void testUser() {
        User user = userService.findUser("testUser@mail.com");

        Assert.assertNotNull(user);

        User admin = userService.findUser("testAdmin@mail.com");

        Assert.assertEquals(admin.getEmail(), "testAdmin@mail.com");

    }

    @Test
    public void testTask() {
        User user = userService.findUser("testUser@mail.com");

        List<Task> tasks = taskService.findUserTasks(user);

        Assert.assertNotNull(tasks);

    }

}
