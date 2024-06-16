package dev.kash.todoapp.model;

import dev.kash.todoapp.domain.Todo;

public class TodoJsonMapper {

    public static TodoJson toJson(Todo todo){
        if(todo == null) return null;

        return new TodoJson(todo.getId(), todo.getTitle(), todo.getDesc());
    }

    public static Todo toTodo(TodoJson json){
        if(json == null) return null;

        Todo todo = new Todo(json.getTitle(), json.getDesc());

        if(json.getId() != null) todo.setId(json.getId());

        return todo;
    }
}
