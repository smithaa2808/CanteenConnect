
package com.canteenconnect.canteen_connect.repository;

import com.canteenconnect.canteen_connect.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FavoriteRepository
        extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUserId(String userId);

    boolean existsByUserIdAndFoodItem_Id(
        String userId, Long foodItemId);

    void deleteByUserIdAndFoodItem_Id(
        String userId, Long foodItemId);
}
