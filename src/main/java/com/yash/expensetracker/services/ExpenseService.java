package com.yash.expensetracker.services;

import com.yash.expensetracker.models.Expense;
import com.yash.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(String expenseId) {
        return expenseRepository.findById(expenseId).orElse(null);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(String expenseId, Expense updatedExpense) {
        if (expenseRepository.existsById(expenseId)) {
            updatedExpense.setId(expenseId);
            return expenseRepository.save(updatedExpense);
        } else {
            return null;
        }
    }

    public boolean deleteExpense(String expenseId) {
        if (expenseRepository.existsById(expenseId)) {
            expenseRepository.deleteById(expenseId);
            return true;
        } else {
            return false;
        }
    }
}

