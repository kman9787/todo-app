package dev.kash.todoapp.repository;

import dev.kash.todoapp.domain.Todo;

public interface TodoCustomRepository {

    public Todo createTodo(String title, String desc);
}
