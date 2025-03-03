package com.kadurodrigues.smart_todo_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String text;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo() {}

    public Todo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }
}

