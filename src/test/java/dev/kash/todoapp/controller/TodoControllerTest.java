package dev.kash.todoapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(controllers = TodoController.class)
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/")).andExpectAll(
                    status().isOk(),
                    view().name("home"),
                    content().string(containsString("Test Page")));
    }
}
