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
