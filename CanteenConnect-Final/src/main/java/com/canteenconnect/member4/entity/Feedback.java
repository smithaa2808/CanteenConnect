package com.canteenconnect.member4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String orderId;
    @Column(nullable=false) private String comments;
    @Column(nullable=false) private LocalDateTime submittedAt;
    public Feedback() {}
    public Feedback(String orderId, String comments) {this.orderId=orderId;this.comments=comments;this.submittedAt=LocalDateTime.now();}
    public Long getId(){return id;} public String getOrderId(){return orderId;} public String getComments(){return comments;} public LocalDateTime getSubmittedAt(){return submittedAt;}
}
