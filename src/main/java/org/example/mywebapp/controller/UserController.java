package org.example.mywebapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@RequestMapping
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/auth")
    public String loginPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth_form";
    }

    @GetMapping("/users")
    public String userPage(Model model) {
        return "users";
    }

    @PostMapping("/auth/process_login")
    public String loginUser(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        User userLogin = userService.login(userDTO);
        if (userLogin != null) {
            ra.addFlashAttribute("message", "Login success.");
            return "redirect:/users";
        } else {
            ra.addFlashAttribute("message", "Login failed. Please check your username and password.");
            return "redirect:/auth";
        }
    }

    @PostMapping("/auth/process_register")
    public String processRegister(UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/auth";
    }
}
