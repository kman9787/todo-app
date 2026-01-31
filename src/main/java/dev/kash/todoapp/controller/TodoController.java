package dev.kash.todoapp.controller;

import dev.kash.todoapp.config.TodoResetEvent;
import dev.kash.todoapp.service.TodoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;
    
    @RequestMapping("/home")
    public String home(Model model){
        todoService.triggerEvent(new TodoResetEvent(this));
        return "home";
    }


//    @GetMapping("/signout")
//    public String logout(Model model){
//        return "logout";
//    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            log.error("Error occurred: {}", status);
        }

        return "error";
    }
}
