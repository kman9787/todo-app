package dev.kash.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TodoController {
    
    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }


//    @GetMapping("/signout")
//    public String logout(Model model){
//        return "logout";
//    }
}
