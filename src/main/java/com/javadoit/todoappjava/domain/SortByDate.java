package com.javadoit.todoappjava.domain;

import java.util.Comparator;

public class SortByDate implements Comparator<Todo> {
    @Override
    public int compare(Todo todo1, Todo todo2) {
        return todo1.getCurrent_date().compareTo(todo2.getCurrent_date());

    }
}
