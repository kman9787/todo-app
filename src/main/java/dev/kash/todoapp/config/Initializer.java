package dev.kash.todoapp.config;

import dev.kash.todoapp.model.Todo;
import dev.kash.todoapp.repository.TodoRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer {

    private final TodoRepository todoRepository;

    public Initializer(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @EventListener({ApplicationReadyEvent.class, TodoResetEvent.class})
    public void reset(){
        this.todoRepository.deleteAll();
        Stream.of(
                "Lear HTML",
                "Learn Spring VIEWComponent",
                "Learn Hotwire",
                "Make some coffee"
        ).forEach( s -> this.todoRepository.save(new Todo(null, s)));

    }
}
