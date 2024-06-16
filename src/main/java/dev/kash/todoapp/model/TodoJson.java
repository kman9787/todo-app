package dev.kash.todoapp.model;

public class TodoJson {
    private Long id;
    private String title;
    private String desc;

    public TodoJson(){}


    public TodoJson(long id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
