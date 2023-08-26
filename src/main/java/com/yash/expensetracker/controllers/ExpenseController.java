package com.yash.expensetracker.controllers;

import com.yash.expensetracker.models.Expense;
import com.yash.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String expenseId) {
        Expense expense = expenseService.getExpenseById(expenseId);
        if (expense != null) {
            return ResponseEntity.ok(expense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.createExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@PathVariable String expenseId, @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(expenseId, expense);
        if (updatedExpense != null) {
            return ResponseEntity.ok(updatedExpense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable String expenseId) {
        boolean deleted = expenseService.deleteExpense(expenseId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
