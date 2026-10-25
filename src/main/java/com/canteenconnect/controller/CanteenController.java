package com.canteenconnect.controller;

import com.canteenconnect.model.Canteen;
import com.canteenconnect.service.CanteenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/canteens")
public class CanteenController {

    private final CanteenService canteenService;

    public CanteenController(CanteenService canteenService) {
        this.canteenService = canteenService;
    }

    @GetMapping
    public List<Canteen> getAllCanteens() {
        return canteenService.getAllCanteens();
    }
}