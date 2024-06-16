package dev.kash.todoapp.repository;

import dev.kash.todoapp.domain.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TodoCustomRepositoryImpl implements TodoCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Todo createTodo(String title, String desc) {
        Todo todo = new Todo(title, desc);
        entityManager.persist(todo);
        return todo;
    }
}
