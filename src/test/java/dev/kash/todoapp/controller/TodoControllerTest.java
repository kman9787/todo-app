package dev.kash.todoapp.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Test
    void testRootPath() throws Exception {
       /* mockMvc.perform(get("/")).andExpectAll(
                    status().isOk(),
                    view().name("home"),
                    content().string(containsString("Test Page")));*/

        mockMvc.perform(get("/")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(formLogin("/login").user("admin").password("password"))
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrl("/home"),
                        authenticated().withRoles("ADMIN", "USER")
                );
    }

    @Test
    void testLoginFailure() throws Exception {
        mockMvc.perform(formLogin("/login").user("admin").password("incorrect"))
                .andExpectAll(
                        status().is2xxSuccessful(),
                        forwardedUrl("/login_failure"),
                        unauthenticated()
                );
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN", "USER"})
    void testHomePage() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpectAll(
                        status().isOk(),
                        content().string(containsString("<h1>Todo App</h1>")));
    }
}
