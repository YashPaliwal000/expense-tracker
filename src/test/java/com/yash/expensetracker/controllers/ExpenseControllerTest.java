package com.yash.expensetracker.controllers;

import com.yash.expensetracker.models.Category;
import com.yash.expensetracker.models.Expense;
import com.yash.expensetracker.services.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ExpenseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ExpenseService expenseService;

    @InjectMocks
    private ExpenseController expenseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
    }

    @Test
    public void testGetAllExpenses() throws Exception {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("1", 100.0, new Date(), "lunch",new Category("1", "Food") ));
        expenses.add(new Expense("2", 50.0, new Date(),"Transport", new Category("2", "Transportation")));

        when(expenseService.getAllExpenses()).thenReturn(expenses);

        mockMvc.perform(get("/api/expenses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expenses.size()));
    }

    // Write similar tests for other API endpoints like getExpenseById, createExpense, updateExpense, deleteExpense
}

