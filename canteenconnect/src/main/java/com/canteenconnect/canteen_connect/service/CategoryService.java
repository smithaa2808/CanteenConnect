
package com.canteenconnect.canteen_connect.service;

import com.canteenconnect.canteen_connect.entity.Category;
import com.canteenconnect.canteen_connect.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(String name) {
        return categoryRepository.save(new Category(name));
    }
}
