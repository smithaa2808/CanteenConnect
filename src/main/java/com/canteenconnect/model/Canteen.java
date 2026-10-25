package com.canteenconnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canteens")
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String openingTime;
    private String closingTime;
    private boolean open;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOpeningTime() {
        return openingTime;
    }
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }
    public String getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }

}