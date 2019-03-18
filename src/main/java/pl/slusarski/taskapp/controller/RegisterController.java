package pl.slusarski.taskapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.slusarski.taskapp.entity.User;
import pl.slusarski.taskapp.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());

        return "view/registerForm";
    }


    @PostMapping("register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "view/registerForm";
        }

        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "view/registerForm";
        }

        userService.createUser(user);

        return "view/success";
    }
}
