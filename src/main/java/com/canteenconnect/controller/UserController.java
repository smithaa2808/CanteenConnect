package com.canteenconnect.controller;

import com.canteenconnect.dto.SelectCanteenRequest;
import com.canteenconnect.dto.UpdateProfileRequest;
import com.canteenconnect.dto.UserResponse;
import com.canteenconnect.model.User;
import com.canteenconnect.service.CanteenService;
import com.canteenconnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CanteenService canteenService;

    public UserController(UserService userService, CanteenService canteenService) {
        this.userService = userService;
        this.canteenService = canteenService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getProfile(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return notLoggedIn();
        try {
            return ResponseEntity.ok(new UserResponse(userService.getProfile(userId)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return notLoggedIn();
        try {
            User user = userService.updateProfile(userId, request);
            return ResponseEntity.ok(new UserResponse(user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/me/canteen")
    public ResponseEntity<?> selectCanteen(@RequestBody SelectCanteenRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return notLoggedIn();
        try {
            User user = canteenService.selectCanteen(userId, request.getCanteenId());
            return ResponseEntity.ok(new UserResponse(user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    private ResponseEntity<?> notLoggedIn() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Please log in first"));
    }
}