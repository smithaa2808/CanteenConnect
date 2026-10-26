package com.canteenconnect.member4.service;
import com.canteenconnect.member4.entity.OrderHistory;import com.canteenconnect.member4.repository.OrderHistoryRepository;import org.springframework.stereotype.Service;import java.util.List;
@Service public class OrderHistoryService { private final OrderHistoryRepository repo; public OrderHistoryService(OrderHistoryRepository repo){this.repo=repo;} public List<OrderHistory> getAll(){return repo.findAllByOrderByCompletedAtDesc();} }
