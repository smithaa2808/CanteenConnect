package com.canteenconnect.service;

import com.canteenconnect.dto.LoginRequest;
import com.canteenconnect.dto.RegisterRequest;
import com.canteenconnect.model.Role;
import com.canteenconnect.model.User;
import com.canteenconnect.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("This email is already registered");
        }
        if (userRepository.existsByStudentId(request.getStudentId())) {
            throw new RuntimeException("This student ID is already registered");
        }

        User user = new User();
        user.setStudentId(request.getStudentId());
        user.setName(request.getName());
        user.setEmail(email);
        user.setPhone(request.getPhone());
        user.setDepartment(request.getDepartment());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.STUDENT);

        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Wrong email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong email or password");
        }

        return user;
    }
}