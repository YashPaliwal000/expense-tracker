package com.yash.expensetracker.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password; // Remember to store hashed passwords
    private List<String> roles;

    // Add other fields as needed
}

