package com.javadoit.todoappjava.domain;

/** Генерирует уникальные ID для пользователей. */
public class IDGenerator {
    private long id;

    public IDGenerator() {
        this.id = 1;
    }

    public long generate() {
        return id++;
    }
}
