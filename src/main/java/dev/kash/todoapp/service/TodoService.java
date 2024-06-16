package dev.kash.todoapp.service;

import dev.kash.todoapp.domain.Todo;
import dev.kash.todoapp.repository.TodoCustomRepository;
import dev.kash.todoapp.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoCustomRepository todoCustomRepository;

    private final TodoRepository todoRepository;

    public TodoService(TodoCustomRepository todoCustomRepository, TodoRepository todoRepository) {
        this.todoCustomRepository = todoCustomRepository;
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Todo saveTodo(String title, String desc){
        return todoCustomRepository.createTodo(title, desc);
    }

    public List<Todo> findAllTodo(){
        return todoRepository.findAll();
    }
}
