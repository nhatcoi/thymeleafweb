package org.example.mywebapp.controller;

import org.example.mywebapp.entity.User;
import org.example.mywebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired private UserService service;


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login_form";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/login/process_login")
    public String loginUser(@ModelAttribute("user") User user, Model model, RedirectAttributes ra) {
        User userLogin = service.login(user);
        if (userLogin != null) {
            ra.addFlashAttribute("message", "Login success.");
            return "redirect:/users";
        } else {
            ra.addFlashAttribute("message", "Login failed.");
            return "redirect:/";
        }
    }


    @PostMapping("/register/process_register")
    public String processRegister(User user) {
        service.save(user);
        return "redirect:/";
    }


}
