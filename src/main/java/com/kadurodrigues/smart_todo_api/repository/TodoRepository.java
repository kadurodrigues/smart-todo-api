package com.kadurodrigues.smart_todo_api.repository;

import com.kadurodrigues.smart_todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, String> {}
