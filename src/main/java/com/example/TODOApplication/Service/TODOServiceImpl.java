package com.example.TODOApplication.Service;

import com.example.TODOApplication.POJO.Todo;
import com.example.TODOApplication.Repository.TODORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TODOServiceImpl implements TODOService {
    @Autowired
    private TODORepository todoRepository;

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void updateTodo(long id, Todo newTodo) {
        Optional<Todo> todoOldBox  = todoRepository.findTODOById(id);
        if(todoOldBox.isPresent()){
            Todo oldTodo = todoOldBox.get();

            oldTodo.setTaskContent(newTodo.getTaskContent());
            oldTodo.setCompletionStatus(newTodo.isCompletionStatus());

            todoRepository.updateTodo(oldTodo);
        }
    }
}
