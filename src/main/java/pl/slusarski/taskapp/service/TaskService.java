package pl.slusarski.taskapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.slusarski.taskapp.entity.Task;
import pl.slusarski.taskapp.entity.User;
import pl.slusarski.taskapp.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);

        taskRepository.save(task);
    }

    public List<Task> findUserTasks(User user) {
        return taskRepository.findByUser(user);
    }
}
