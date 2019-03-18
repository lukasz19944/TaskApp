package pl.slusarski.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.slusarski.taskapp.entity.Task;
import pl.slusarski.taskapp.entity.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
