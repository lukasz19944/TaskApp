package pl.slusarski.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.slusarski.taskapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
