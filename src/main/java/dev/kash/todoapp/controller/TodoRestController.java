package dev.kash.todoapp.controller;

import dev.kash.todoapp.domain.Todo;
import dev.kash.todoapp.model.TodoJson;
import dev.kash.todoapp.model.TodoJsonMapper;
import dev.kash.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/save")
    public TodoJson saveTodo(@RequestParam String title, @RequestParam String desc){
        Todo todo = todoService.saveTodo(title, desc);
        return TodoJsonMapper.toJson(todo);
    }

    @GetMapping("/all")
    public List<TodoJson> findAllTodos(){
        List<Todo> todos = todoService.findAllTodo();

        if (todos == null || todos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return todos.stream().map(TodoJsonMapper::toJson).toList();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/user")
    public String user(){
        return "Hello user";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "Hello admin";
    }
}
