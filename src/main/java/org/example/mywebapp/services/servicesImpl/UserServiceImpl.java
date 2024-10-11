package org.example.mywebapp.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.dto.UserDTO;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.UserRepository;
import org.example.mywebapp.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public User login(UserDTO userDTO) {
        return repo.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        repo.save(user);
    }
}
