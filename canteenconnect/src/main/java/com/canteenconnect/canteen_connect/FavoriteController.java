
package com.canteenconnect.canteen_connect;

import com.canteenconnect.canteen_connect.entity.Favorite;
import com.canteenconnect.canteen_connect.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<Favorite> getFavorites(
            @RequestParam(defaultValue = "demo") String userId) {
        return favoriteService.getFavorites(userId);
    }

    @PostMapping("/{foodItemId}")
    public Favorite addFavorite(
            @RequestParam(defaultValue = "demo") String userId,
            @PathVariable Long foodItemId) {
        return favoriteService.addFavorite(userId, foodItemId);
    }

    @DeleteMapping("/{foodItemId}")
    public void removeFavorite(
            @RequestParam(defaultValue = "demo") String userId,
            @PathVariable Long foodItemId) {
        favoriteService.removeFavorite(userId, foodItemId);
    }
}
