package com.canteenconnect.member4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_history")
public class OrderHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String orderId;
    @Column(nullable=false) private String itemSummary;
    @Column(nullable=false) private String finalStatus;
    @Column(nullable=false) private LocalDateTime completedAt;
    public OrderHistory() {}
    public OrderHistory(String orderId, String itemSummary, String finalStatus) { this.orderId=orderId;this.itemSummary=itemSummary;this.finalStatus=finalStatus;this.completedAt=LocalDateTime.now(); }
    public Long getId(){return id;} public String getOrderId(){return orderId;} public String getItemSummary(){return itemSummary;}
    public String getFinalStatus(){return finalStatus;} public LocalDateTime getCompletedAt(){return completedAt;}
}
