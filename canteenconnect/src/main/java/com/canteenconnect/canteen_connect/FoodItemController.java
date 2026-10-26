
package com.canteenconnect.canteen_connect;

import com.canteenconnect.canteen_connect.entity.FoodItem;
import com.canteenconnect.canteen_connect.repository.FoodItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

    private final FoodItemRepository foodItemRepository;

    public FoodItemController(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @GetMapping("/search")
    public List<FoodItem> searchFoodItems(@RequestParam String name) {
        return foodItemRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/{id}")
    public FoodItem getFoodItemById(@PathVariable Long id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    @PostMapping
    public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @GetMapping("/category/{category}")
    public List<FoodItem> getFoodItemsByCategory(
            @PathVariable String category) {
        return foodItemRepository.findByCategoryIgnoreCase(category);
    }

}
