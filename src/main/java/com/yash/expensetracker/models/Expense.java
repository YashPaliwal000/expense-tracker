package com.yash.expensetracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private double amount;
    private Date date;
    private String description;
    private Category category;

    // Add other fields as needed
}
