package org.example.mywebapp.services;

import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.StaffRepository;
import org.example.mywebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User login(User user) {
        return repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public void save(User user) {
        repo.save(user);
    }
}
