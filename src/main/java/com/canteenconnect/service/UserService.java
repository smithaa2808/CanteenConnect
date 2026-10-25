package com.canteenconnect.service;

import com.canteenconnect.dto.UpdateProfileRequest;
import com.canteenconnect.model.User;
import com.canteenconnect.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getProfile(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateProfile(Long userId, UpdateProfileRequest request) {
        User user = getProfile(userId);
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setDepartment(request.getDepartment());
        return userRepository.save(user);
    }
}