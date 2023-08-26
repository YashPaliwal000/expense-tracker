package com.yash.expensetracker.repositories;

import com.yash.expensetracker.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    // Add custom query methods if needed
}

