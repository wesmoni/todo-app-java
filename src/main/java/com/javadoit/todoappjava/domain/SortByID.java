package com.javadoit.todoappjava.domain;

import java.util.Comparator;

public class SortByID implements Comparator<Todo> {

    @Override
    public int compare(Todo todo1, Todo todo2) {
        return todo1.getId().compareTo(todo2.getId());

    }
}