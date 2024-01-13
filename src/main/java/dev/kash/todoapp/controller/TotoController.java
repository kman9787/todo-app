package dev.kash.todoapp.controller;

import dev.kash.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TotoController {

    private final TodoRepository todoRepository;

    public TotoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("")
    public String todos(Model model){
        model.addAttribute("todos", this.todoRepository.findAll());
        return "todos.html";
    }


}
