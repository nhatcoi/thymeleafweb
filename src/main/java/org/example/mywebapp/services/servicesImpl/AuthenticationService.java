package org.example.mywebapp.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.example.mywebapp.dto.AuthenticationRequest;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
