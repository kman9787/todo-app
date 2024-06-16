package dev.kash.todoapp.config;

import dev.kash.todoapp.repository.TodoRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    private final TodoRepository todoRepository;

    public Initializer(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @EventListener({ApplicationReadyEvent.class, TodoResetEvent.class})
    public void init(){


    }
}
