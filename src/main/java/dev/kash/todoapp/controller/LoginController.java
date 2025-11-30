package dev.kash.todoapp.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) Boolean error, Model model){
        if(error != null && error) {
            model.addAttribute("msg", "Incorrect username or password. Please try again");
            model.addAttribute("error", Boolean.TRUE);
        }

        return "login";
    }

    @GetMapping("/logout")
    public String performLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/login_failure")
    public String handleLoginFailure() {
        log.error("Failed to login.");
        return "redirect:/login?error=true"; // Redirect to the login page with an error parameter
    }
}
