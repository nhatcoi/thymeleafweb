package org.example.mywebapp.services;

import org.example.mywebapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    User login(User user);
    void save(User user);
}