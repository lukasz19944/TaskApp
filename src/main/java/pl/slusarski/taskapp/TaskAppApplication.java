package pl.slusarski.taskapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.slusarski.taskapp.entity.User;
import pl.slusarski.taskapp.service.UserService;

@SpringBootApplication
public class TaskAppApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TaskAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User admin = new User("admin@gmail.com", "Admin", "admin");
        userService.createAdmin(admin);
    }
}
