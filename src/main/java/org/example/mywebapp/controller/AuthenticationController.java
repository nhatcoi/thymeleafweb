package org.example.mywebapp.controller;


import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.mywebapp.dto.AuthenticationRequest;
import org.example.mywebapp.dto.AuthenticationResponse;
import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.services.servicesImpl.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Controller
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/auth/log-in")
    public String authenticate(@RequestBody @ModelAttribute("user") AuthenticationRequest request, RedirectAttributes ra) throws JOSEException {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        if (authenticationResponse.isAuthenticated()) {
            ra.addFlashAttribute("message", "Login success.");
            return "users";
        } else {
            ra.addFlashAttribute("message", "Login failed. Please check your username and password.");
            return "redirect:/auth_form";
        }
    }

    @PostMapping("/auth/introspect")
    public String introspect(@RequestBody @ModelAttribute("user") AuthenticationRequest request, RedirectAttributes ra) throws JOSEException {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        if (authenticationResponse.isAuthenticated()) {
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
