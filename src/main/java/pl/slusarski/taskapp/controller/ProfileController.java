package pl.slusarski.taskapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.slusarski.taskapp.entity.User;
import pl.slusarski.taskapp.service.TaskService;
import pl.slusarski.taskapp.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.findUser(email);

        model.addAttribute("tasks", taskService.findUserTasks(user));

        return "/view/profile";
    }
}
