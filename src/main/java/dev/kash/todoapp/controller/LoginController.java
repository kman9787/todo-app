package dev.kash.todoapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) Boolean error){
        return "login";
    }

    @GetMapping("/logoutx")
    public String performLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}
