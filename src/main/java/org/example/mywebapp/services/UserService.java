package org.example.mywebapp.services;

import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    User login(UserDTO user);
    User createUser(UserDTO user);
}