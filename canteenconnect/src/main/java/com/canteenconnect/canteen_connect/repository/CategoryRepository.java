
package com.canteenconnect.canteen_connect.repository;

import com.canteenconnect.canteen_connect.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
