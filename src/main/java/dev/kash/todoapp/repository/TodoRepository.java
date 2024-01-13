package dev.kash.todoapp.repository;

import dev.kash.todoapp.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo, Integer> {

}
