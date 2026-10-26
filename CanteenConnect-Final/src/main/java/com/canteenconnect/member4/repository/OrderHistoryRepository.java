package com.canteenconnect.member4.repository;
import com.canteenconnect.member4.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> { List<OrderHistory> findAllByOrderByCompletedAtDesc(); }
