package com.github.pvkr.todo.service;

import com.github.pvkr.todo.domain.TodoItem;
import com.github.pvkr.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public List<TodoItem> getTodoItems() {
        return todoItemRepository.findAll();
    }
}
