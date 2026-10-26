package com.canteenconnect.member4.controller;
import com.canteenconnect.member4.entity.OrderHistory;import com.canteenconnect.member4.service.OrderHistoryService;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/order-history") @CrossOrigin
public class OrderHistoryController {private final OrderHistoryService service;public OrderHistoryController(OrderHistoryService service){this.service=service;}@GetMapping public List<OrderHistory> all(){return service.getAll();}}
