package org.example.mywebapp.controller;


import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mywebapp.dto.AuthenticationRequest;
import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.services.servicesImpl.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Controller
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/auth/log-in")
    public String authenticate(@ModelAttribute("user") AuthenticationRequest request, RedirectAttributes ra) {
        boolean authenticated = authenticationService.authenticate(request);
        if (authenticated) {
            ra.addFlashAttribute("message", "Login success.");
            return "users";
        } else {
            ra.addFlashAttribute("message", "Login failed. Please check your username and password.");
            return "redirect:/auth_form";
        }
    }

    @GetMapping("/auth_form")
    public String authPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth_form";
    }
}
