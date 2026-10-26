package com.canteenconnect.member4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_tracking")
public class OrderTracking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true) private String orderId;
    @Column(nullable = false) private String itemSummary;
    @Column(nullable = false) private String status;
    @Column(nullable = false) private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderTracking() {}
    public OrderTracking(String orderId, String itemSummary, String status) {
        this.orderId = orderId; this.itemSummary = itemSummary; this.status = status;
        this.createdAt = LocalDateTime.now(); this.updatedAt = this.createdAt;
    }
    @PrePersist void onCreate() { if (createdAt == null) createdAt = LocalDateTime.now(); if (updatedAt == null) updatedAt = createdAt; }
    @PreUpdate void onUpdate() { updatedAt = LocalDateTime.now(); }
    public Long getId(){return id;} public String getOrderId(){return orderId;} public void setOrderId(String v){orderId=v;}
    public String getItemSummary(){return itemSummary;} public void setItemSummary(String v){itemSummary=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}
