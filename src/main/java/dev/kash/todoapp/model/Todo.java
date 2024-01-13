package dev.kash.todoapp.model;

import org.springframework.data.annotation.Id;

public record Todo(
        @Id Integer id,
        String title
) {
}
