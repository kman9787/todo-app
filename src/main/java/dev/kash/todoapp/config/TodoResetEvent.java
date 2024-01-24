package dev.kash.todoapp.config;

import org.springframework.context.ApplicationEvent;

public class TodoResetEvent extends ApplicationEvent {
    public TodoResetEvent(Object source) {
        super(source);
    }
}
