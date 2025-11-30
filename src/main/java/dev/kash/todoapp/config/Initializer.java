package dev.kash.todoapp.config;

import dev.kash.todoapp.config.annotations.ConditionalOnLapseDateTimeProperty;
import dev.kash.todoapp.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnLapseDateTimeProperty(name = "app.component.initializer.featureToggleDateTime")
public class Initializer {

    private final TodoRepository todoRepository;

    public Initializer(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        log.info("Initializing....");
    }

    @EventListener(TodoResetEvent.class)
    public void todoReset(){
        log.info("Resetting.....");
        //throw new RuntimeException("Shit...");
    }
}
