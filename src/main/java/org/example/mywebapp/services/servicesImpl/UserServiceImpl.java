package org.example.mywebapp.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.UserRepository;
import org.example.mywebapp.services.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public User login(User user) {
        return repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }
}
