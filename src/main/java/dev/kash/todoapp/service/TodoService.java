package dev.kash.todoapp.service;

import dev.kash.todoapp.domain.Todo;
import dev.kash.todoapp.repository.TodoCustomRepository;
import dev.kash.todoapp.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoCustomRepository todoCustomRepository;
    private final ApplicationEventPublisher  applicationEventPublisher;
    private final TodoRepository todoRepository;

    @Transactional
    public Todo saveTodo(String title, String desc){
        return todoCustomRepository.createTodo(title, desc);
    }

    public List<Todo> findAllTodo(){
        return todoRepository.findAll();
    }

    public void triggerEvent(ApplicationEvent event){
        applicationEventPublisher.publishEvent(event);
    }
}
