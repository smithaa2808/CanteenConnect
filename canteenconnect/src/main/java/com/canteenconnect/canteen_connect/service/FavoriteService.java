
package com.canteenconnect.canteen_connect.service;

import com.canteenconnect.canteen_connect.entity.Favorite;
import com.canteenconnect.canteen_connect.entity.FoodItem;
import com.canteenconnect.canteen_connect.repository.FavoriteRepository;
import com.canteenconnect.canteen_connect.repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FoodItemRepository foodItemRepository;

    public FavoriteService(
            FavoriteRepository favoriteRepository,
            FoodItemRepository foodItemRepository) {
        this.favoriteRepository = favoriteRepository;
        this.foodItemRepository = foodItemRepository;
    }

    public List<Favorite> getFavorites(String userId) {
        return favoriteRepository.findByUserId(userId);
    }

    public Favorite addFavorite(String userId, Long foodItemId) {
        if (favoriteRepository.existsByUserIdAndFoodItem_Id(
                userId, foodItemId)) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Already in favorites");
        }

        FoodItem food = foodItemRepository.findById(foodItemId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Food item not found"));

        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setFoodItem(food);

        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(String userId, Long foodItemId) {
        favoriteRepository.deleteByUserIdAndFoodItem_Id(
            userId, foodItemId);
    }
}
