package com.canteenconnect.dto;

import com.canteenconnect.model.User;

public class UserResponse {
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String role;
    private Long selectedCanteenId;
    private String selectedCanteenName;

    public UserResponse(User user) {
        this.id = user.getId();
        this.studentId = user.getStudentId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.department = user.getDepartment();
        this.role = user.getRole().name();
        if (user.getSelectedCanteen() != null) {
            this.selectedCanteenId = user.getSelectedCanteen().getId();
            this.selectedCanteenName = user.getSelectedCanteen().getName();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getSelectedCanteenId() {
        return selectedCanteenId;
    }

    public void setSelectedCanteenId(Long selectedCanteenId) {
        this.selectedCanteenId = selectedCanteenId;
    }

    public String getSelectedCanteenName() {
        return selectedCanteenName;
    }

    public void setSelectedCanteenName(String selectedCanteenName) {
        this.selectedCanteenName = selectedCanteenName;
    }
}