package com.javadoit.todoappjava.domain;

import java.time.LocalDateTime;
import java.util.List;

/** Todo content */
public class Todo {

    private long id;
    private String content;
    private List<Todo> parents;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime finishAt;

    /** */
    public Todo(long id, String content, List<Todo> parents) {
        if (content.equals(" ")) {
            throw new IllegalArgumentException(" ");
        }
        this.id = id;
        this.content = content;
        this.createAt = LocalDateTime.now();
        this.parents = parents;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public List<Todo> getParents() {
        return parents;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public LocalDateTime getFinishAt() {
        return finishAt;
    }

    /**
     *
     * @param content
     * @param parents
     */
    public void update(String content, List<Todo> parents) {
        this.content = content;
        this.parents = parents;
        this.updateAt = LocalDateTime.now();
    }

    /**
     *
     */
    public void finish() {
        this.finishAt = LocalDateTime.now();
    }

    /**
     *
     */
    public void checkFinished() {
        if (this.finishAt == null) {
            throw new IllegalStateException("");
        }
    }
}
