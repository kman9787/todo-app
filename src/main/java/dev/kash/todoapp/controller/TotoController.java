package dev.kash.todoapp.controller;

import dev.kash.todoapp.config.TodoResetEvent;
import dev.kash.todoapp.model.Todo;
import dev.kash.todoapp.repository.TodoRepository;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
@RequestMapping("/todos")
public class TotoController {

    private final TodoRepository todoRepository;
    private final ApplicationEventPublisher eventPublisher;

    public TotoController(TodoRepository todoRepository, ApplicationEventPublisher eventPublisher) {
        this.todoRepository = todoRepository;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping
    public String todos(Model model){
        model.addAttribute("todos", this.todoRepository.findAll());
        return "todos";
    }

    @PostMapping
    public HtmxResponse add(@RequestParam("new-todo") String title, Model model){
        this.todoRepository.save(new Todo(null, title));
        model.addAttribute("todos", this.todoRepository.findAll());

        return HtmxResponse.builder()
                .view("todos::todos-form")
                .view("todos::todos-list")
                .build();

        /*
        return new HtmxResponse()
                .addTemplate("todos::todos-form")
                .addTemplate("todos::todos-list");

         */
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String delete (@PathVariable Integer id) {
        System.out.println("Deleting todo = " + id);

        this.todoRepository.findById(id).ifPresent(todo -> {
            this.todoRepository.deleteById(id);
        });

        return "";
    }

    @PostMapping("reset")
    public String reset(Model model){
        eventPublisher.publishEvent(new TodoResetEvent(Instant.now()));
        model.addAttribute("todos", this.todoRepository.findAll());

        // Fragment name inside todos.html
        return "todos::todos-list";
    }
}
