package org.example.mywebapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RequestMapping
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }


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

    @GetMapping("/staff_manager")
    public String staffManager(Model model) {
        model.addAttribute("staff_manager", new User());
        return "staffs";
    }



//    @GetMapping("/list_users")
//    public String viewUserList(Model model) {
//        model.addAttribute("listUsers", userService.listAll());
//        return "users";
//    }



    @PostMapping("/login/process_login")
    public String loginUser(@ModelAttribute("user") User user, RedirectAttributes ra) {
        User userLogin = userService.login(user);
        if (userLogin != null) {
            ra.addFlashAttribute("message", "Login success.");
            return "redirect:/users";
        } else {
            ra.addFlashAttribute("message", "Login failed. Please check your username and password.");
            return "redirect:/login";
        }
    }

    @PostMapping("/register/process_register")
    public String processRegister(User user) {
        userService.save(user);
        return "redirect:/";
    }



}
