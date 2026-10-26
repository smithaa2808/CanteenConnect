
package com.canteenconnect.canteen_connect;

import com.canteenconnect.canteen_connect.entity.Category;
import com.canteenconnect.canteen_connect.entity.FoodItem;
import com.canteenconnect.canteen_connect.repository.CategoryRepository;
import com.canteenconnect.canteen_connect.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuDataLoader implements CommandLineRunner {

    private final FoodItemRepository foodItemRepository;
    private final CategoryRepository categoryRepository;

    public MenuDataLoader(
            FoodItemRepository foodItemRepository,
            CategoryRepository categoryRepository) {
        this.foodItemRepository = foodItemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        loadCategories();

        int added = 0;

        added += addItem("Chicken 65 (Bone)", 80, "Chinese", false);
        added += addItem("Chicken Fried Rice", 130, "Chinese", false);
        added += addItem("Chicken Kothu Parotta", 130, "Chinese", false);
        added += addItem("Chicken Macaroni", 130, "Chinese", false);
        added += addItem("Chicken Manchuriani", 130, "Chinese", false);
        added += addItem("Chicken Noodles", 130, "Chinese", false);
        added += addItem("Chicken Pasta", 110, "Chinese", false);
        added += addItem("Chilli Chicken", 110, "Chinese", false);
        added += addItem("Chilly Parotta", 60, "Chinese", true);
        added += addItem("Egg Bonda (1 No.)", 15, "Chinese", false);
        added += addItem("Egg Dosai", 40, "Chinese", false);
        added += addItem("Egg Fried Rice", 35, "Chinese", false);
        added += addItem("Egg Full Boil", 15, "Chinese", false);
        added += addItem("Egg Kalaki", 24, "Chinese", false);
        added += addItem("Egg Kothu Parotta", 30, "Chinese", false);
        added += addItem("Egg Macaroni", 90, "Chinese", false);
        added += addItem("Egg Pasta", 90, "Chinese", false);
        added += addItem("Half Boiled Egg", 20, "Chinese", false);
        added += addItem("Omelette", 80, "Chinese", false);
        added += addItem("Veg Macaroni", 80, "Chinese", true);
        added += addItem("Veg Pasta", 80, "Chinese", true);

        added += addItem("Aloo Chaat", 30, "Chat", true);
        added += addItem("Aloo Puri", 30, "Chat", true);
        added += addItem("Aloo Samosa", 15, "Chat", true);
        added += addItem("Bhel Puri", 30, "Chat", true);
        added += addItem("Bread Omelette", 40, "Chat", false);
        added += addItem("Chenna Masala", 40, "Chat", true);
        added += addItem("Coffee", 15, "Chat", true);
        added += addItem("Dahi Puri", 50, "Chat", true);
        added += addItem("Dahi Samosa", 40, "Chat", true);
        added += addItem("Egg Puff", 15, "Chat", false);
        added += addItem("Fry Pav Bhaji", 60, "Chat", true);
        added += addItem("Masala Puri", 40, "Chat", true);
        added += addItem("Mix Chaat", 50, "Chat", true);
        added += addItem("Pani Puri", 25, "Chat", true);
        added += addItem("Papdi Chaat", 40, "Chat", true);
        added += addItem("Parcel Chat Items", 5, "Chat", true);
        added += addItem("Pav Bhaji", 50, "Chat", true);
        added += addItem("Samosa Chenna", 40, "Chat", true);
        added += addItem("Sav Puri", 40, "Chat", true);
        added += addItem("Tea", 12, "Chat", true);

        added += addItem("Chapati (1 no.)", 15, "South Indian", true);
        added += addItem("Curd Vadai", 30, "South Indian", true);
        added += addItem("Ghee Dosai", 40, "South Indian", true);
        added += addItem("Idli (1 no.)", 10, "South Indian", true);
        added += addItem("Kal Dosai", 15, "South Indian", true);
        added += addItem("Masala Dosai", 40, "South Indian", true);
        added += addItem("Mini Idli (14 nos.)", 20, "South Indian", true);
        added += addItem("Onion Dosa", 30, "South Indian", true);
        added += addItem("Parotta (2 nos.)", 40, "South Indian", true);
        added += addItem("Poori (2 nos.)", 25, "South Indian", true);

        System.out.println(
                "Menu import complete. New items added: " + added);
    }

    private void loadCategories() {
        String[] categories = {"Chinese", "Chat", "South Indian"};

        for (String name : categories) {
            boolean exists = categoryRepository.findAll()
                    .stream()
                    .anyMatch(category -> category.getName() != null
                            && category.getName().equalsIgnoreCase(name));

            if (!exists) {
                categoryRepository.save(new Category(name));
            }
        }

        System.out.println("Categories loaded successfully.");
    }

    private int addItem(
            String name,
            double price,
            String category,
            boolean vegetarian) {

        FoodItem item = foodItemRepository.findAll()
                .stream()
                .filter(food -> food.getName() != null
                        && food.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        boolean isNew = (item == null);

        if (isNew) {
            item = new FoodItem();
            item.setName(name);
            item.setPrice(price);
            item.setCategory(category);
            item.setVegetarian(vegetarian);
            item.setAvailable(true);
        }

        if (item.getDescription() == null
                || item.getDescription().isBlank()) {
            item.setDescription(
                    "Freshly prepared " + name
                            + ", served from our canteen.");
        }

        String foodName = name.toLowerCase();

        if (foodName.contains("tea") || foodName.contains("coffee")) {
            item.setPreparationTime(5);
        } else if (foodName.contains("idli")) {
            item.setPreparationTime(5);
        } else if (foodName.contains("chaat")
                || foodName.contains("puri")
                || foodName.contains("samosa")) {
            item.setPreparationTime(8);
        } else if (foodName.contains("dosa")
                || foodName.contains("dosai")) {
            item.setPreparationTime(10);
        } else if (foodName.contains("fried rice")
                || foodName.contains("noodles")) {
            item.setPreparationTime(12);
        } else if (foodName.contains("chicken 65")) {
            item.setPreparationTime(15);
        } else {
            item.setPreparationTime(10);
        }

        foodItemRepository.save(item);

        return isNew ? 1 : 0;
    }
}
