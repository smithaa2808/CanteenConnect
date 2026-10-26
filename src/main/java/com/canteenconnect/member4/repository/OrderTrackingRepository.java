package com.canteenconnect.member4.repository;
import com.canteenconnect.member4.entity.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface OrderTrackingRepository extends JpaRepository<OrderTracking,Long> { Optional<OrderTracking> findByOrderId(String orderId); }
