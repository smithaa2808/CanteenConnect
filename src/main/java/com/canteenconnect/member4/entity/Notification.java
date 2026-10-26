package com.canteenconnect.member4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String message;
    @Column(nullable=false) private LocalDateTime createdAt;
    private boolean readStatus;
    public Notification() {}
    public Notification(String message) { this.message=message;this.createdAt=LocalDateTime.now();this.readStatus=false; }
    public Long getId(){return id;} public String getMessage(){return message;} public LocalDateTime getCreatedAt(){return createdAt;}
    public boolean isReadStatus(){return readStatus;} public void setReadStatus(boolean v){readStatus=v;}
}
