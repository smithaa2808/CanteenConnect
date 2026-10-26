
package com.canteenconnect.canteen_connect.repository;

import com.canteenconnect.canteen_connect.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByNameContainingIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    List<FoodItem> findByCategoryIgnoreCase(String category);
}
