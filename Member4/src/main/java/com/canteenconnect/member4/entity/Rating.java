package com.canteenconnect.member4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String orderId;
    @Column(nullable=false) private int score;
    @Column(nullable=false) private LocalDateTime submittedAt;
    public Rating() {}
    public Rating(String orderId, int score) {this.orderId=orderId;this.score=score;this.submittedAt=LocalDateTime.now();}
    public Long getId(){return id;} public String getOrderId(){return orderId;} public int getScore(){return score;} public LocalDateTime getSubmittedAt(){return submittedAt;}
}
