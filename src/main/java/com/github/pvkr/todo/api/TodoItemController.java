package com.github.pvkr.todo.api;

import com.github.pvkr.todo.annotation.RestApiV1Controller;
import com.github.pvkr.todo.domain.TodoItem;
import com.github.pvkr.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestApiV1Controller
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/todo/items")
    public List<TodoItem> getTodoItems() {
        return todoItemService.getTodoItems();
    }
}
