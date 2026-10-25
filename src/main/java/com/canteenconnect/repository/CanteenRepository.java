package com.canteenconnect.repository;

import com.canteenconnect.model.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanteenRepository extends JpaRepository<Canteen, Long> {
}