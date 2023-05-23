package com.javadoit.todoappjava.processor;

import com.javadoit.todoappjava.domain.Todo;
import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Parameters;
import java.util.List;

/** Обновляет список дел. */
public class UpdateProcessor implements Processor {

    private Repository Repository;

    public UpdateProcessor(Repository Repository) {
        this.Repository = Repository;
    }

    @Override
    public void run(Parameters Parameters) {
        List<Todo> dependencies = Repository.findAll(Parameters.getIds());
        Todo toBeUpdated = Repository.find(Parameters.getId());
        if (dependencies.contains(toBeUpdated)) {
            throw new IllegalStateException("Ошибка.");
        }
        toBeUpdated.update(Parameters.getContent(), dependencies);
    }
}
