package com.javadoit.todoappjava.processor;

import com.javadoit.todoappjava.domain.Todo;
import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Parameters;
import java.util.List;

/** Удаляет пункт из списка дел. */
public class RemoveProcessor implements Processor {

    private Repository Repository;

    public RemoveProcessor(Repository Repository) {
        this.Repository = Repository;
    }

    @Override
    public void run(Parameters Parameters) {
        List<Todo> children = Repository.findAllChildren(Parameters.getId());
        if (!children.isEmpty()) {
            throw new IllegalStateException("Ошибка.");
        }
        Todo toBeRemoved = Repository.find(Parameters.getId());
        Repository.remove(toBeRemoved);
    }
}
