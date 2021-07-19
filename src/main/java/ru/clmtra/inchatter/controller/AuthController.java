package ru.clmtra.inchatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.clmtra.inchatter.model.User;
import ru.clmtra.inchatter.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class AuthController {

    private final UserServiceImpl userService;

    @Autowired
    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String redirectToAuthForm() {
        return "login";
    }

    @GetMapping("/auth")
    public String getAuthForm() {
        return "login";
    }

    @PostMapping("/auth")
    public String authUser() {
        return "redirect:/success";
    }

    @GetMapping("/registration")
    public String openRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "error-page";
        }
        userService.saveUser(user);

        return "redirect:/success"; // todo check
    }

}
