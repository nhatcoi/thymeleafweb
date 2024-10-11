package org.example.mywebapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@RequestMapping
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/auth/process_login")
    public String loginUser(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        User userLogin = userService.login(userDTO);
        if (userLogin != null) {
            ra.addFlashAttribute("message", "Login success.");
            return "redirect:/users";
        } else {
            ra.addFlashAttribute("message", "Login failed. Please check your username and password.");
            return "redirect:/auth_form";
        }
    }

    @PostMapping("/auth/process_register")
    public String processRegister(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        User user = userService.createUser(userDTO);
        if(user != null) {
            ra.addFlashAttribute("message", "Register success.");
        } else {
            ra.addFlashAttribute("message", "Register failed. Username already exists.");
        }
        return "redirect:/auth_form";
    }
}
