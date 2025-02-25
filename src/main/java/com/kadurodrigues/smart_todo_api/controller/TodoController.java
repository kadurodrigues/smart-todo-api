package com.kadurodrigues.smart_todo_api.controller;

import com.kadurodrigues.smart_todo_api.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    private final List<Todo> todos = new ArrayList<>();

    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        Todo newTodo = new Todo(todo.getText(), todo.isCompleted());
        todos.add(newTodo);
        return newTodo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todoDetails) {
        Todo todoFound = findTodoById(id);
        if (todoFound != null) {
            todoFound.setText(todoDetails.getText());
            todoFound.setCompleted(todoDetails.isCompleted());
        }
        return todoFound;
    }

    @PatchMapping("/{id}/toggle")
    public Todo toggleTodo(@PathVariable String id) {
        Todo todo = findTodoById(id);
        if (todo != null) todo.setCompleted(!todo.isCompleted());
        return todo;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteTodo(@PathVariable String id) {
        boolean removed = todos.removeIf(todo -> todo.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok().build(); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    private Todo findTodoById(String id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
