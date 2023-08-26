package com.yash.expensetracker.repositories;

import com.yash.expensetracker.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    // You can add custom query methods if needed
}

