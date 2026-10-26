package com.canteenconnect.member4.controller;
import com.canteenconnect.member4.entity.Notification;import com.canteenconnect.member4.service.NotificationService;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/notifications") @CrossOrigin
public class NotificationController {private final NotificationService service;public NotificationController(NotificationService service){this.service=service;}@GetMapping public List<Notification> all(){return service.getAll();}@PatchMapping("/{id}/read") public Notification markRead(@PathVariable Long id){return service.markRead(id);}}
