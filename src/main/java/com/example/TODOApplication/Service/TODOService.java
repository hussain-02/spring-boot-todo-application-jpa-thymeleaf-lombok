package com.example.TODOApplication.Service;

import com.example.TODOApplication.POJO.Todo;

import java.util.List;

public interface TODOService {
    void saveTodo(Todo todo);

    List<Todo> getAllTodos();

    void updateTodo(long id, Todo todo);
}
