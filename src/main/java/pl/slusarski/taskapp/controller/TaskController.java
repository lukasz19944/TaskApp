package pl.slusarski.taskapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.slusarski.taskapp.entity.Task;
import pl.slusarski.taskapp.service.TaskService;
import pl.slusarski.taskapp.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession httpSession) {
        httpSession.setAttribute("email", email);
        model.addAttribute("task", new Task());

        return "view/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "view/taskForm";
        }

        String email = httpSession.getAttribute("email").toString();
        taskService.addTask(task, userService.findUser(email));

        return "redirect:/users";
    }
}
