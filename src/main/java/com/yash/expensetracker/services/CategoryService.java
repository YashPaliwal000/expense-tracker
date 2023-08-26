package com.yash.expensetracker.services;

import com.yash.expensetracker.models.Category;
import com.yash.expensetracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(String categoryId, Category updatedCategory) {
        if (categoryRepository.existsById(categoryId)) {
            updatedCategory.setId(categoryId);
            return categoryRepository.save(updatedCategory);
        } else {
            return null;
        }
    }

    public boolean deleteCategory(String categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return true;
        } else {
            return false;
        }
    }
}

