package dev.kash.todoapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String desc;

    @Column(name = "created_datetime")
    private LocalDateTime createdTimeStamp;

    @Column(name = "updated_datetime")
    private LocalDateTime updatedTimeStamp;

    public Todo(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}
