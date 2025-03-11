package com.kadurodrigues.smart_todo_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "TODO")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean completed;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructor for creating a new Todo
    public Todo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    // Default constructor required by JPA
    public Todo() {
    }
}

