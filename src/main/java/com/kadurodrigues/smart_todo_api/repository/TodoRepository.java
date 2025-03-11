package com.kadurodrigues.smart_todo_api.repository;

import com.kadurodrigues.smart_todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {}
