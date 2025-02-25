package com.kadurodrigues.smart_todo_api.model;

import lombok.Data;

@Data
public class Todo {
    private String id;
    private String text;
    private boolean completed;

    public Todo(String text, boolean completed) {
        this.id = java.util.UUID.randomUUID().toString();
        this.text = text;
        this.completed = completed;
    }
}

