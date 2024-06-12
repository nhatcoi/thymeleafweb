package org.example.mywebapp;

import org.example.mywebapp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String homeHomePage() {
        System.out.println("Main Controller");
        return "index";
    }



}
