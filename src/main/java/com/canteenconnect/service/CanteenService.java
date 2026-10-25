package com.canteenconnect.service;

import com.canteenconnect.model.Canteen;
import com.canteenconnect.model.User;
import com.canteenconnect.repository.CanteenRepository;
import com.canteenconnect.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenService {

    private final CanteenRepository canteenRepository;
    private final UserRepository userRepository;

    public CanteenService(CanteenRepository canteenRepository, UserRepository userRepository) {
        this.canteenRepository = canteenRepository;
        this.userRepository = userRepository;
    }

    public List<Canteen> getAllCanteens() {
        return canteenRepository.findAll();
    }

    public User selectCanteen(Long userId, Long canteenId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Canteen canteen = canteenRepository.findById(canteenId)
                .orElseThrow(() -> new RuntimeException("Canteen not found"));

        if (!canteen.isOpen()) {
            throw new RuntimeException("This canteen is currently closed");
        }

        user.setSelectedCanteen(canteen);
        return userRepository.save(user);
    }
}