package pl.slusarski.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.slusarski.taskapp.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameLike(String name);
}
