package com.github.pvkr.todo.repository;

import com.github.pvkr.todo.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
