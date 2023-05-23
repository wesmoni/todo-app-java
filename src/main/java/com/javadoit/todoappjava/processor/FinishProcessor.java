package com.javadoit.todoappjava.processor;

import com.javadoit.todoappjava.domain.Todo;
import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Parameters;
import java.util.List;

/** Завершает выполнение дел. */
public class FinishProcessor implements Processor {

    private Repository Repository;

    public FinishProcessor(Repository Repository) {
        this.Repository = Repository;
    }

    @Override
    public void run(Parameters Parameters) {
        List<Todo> children = Repository.findAllChildren(Parameters.getId());
        for (Todo child : children) {
            child.checkFinished();
        }
        Todo toBeFinished = Repository.find(Parameters.getId());
        toBeFinished.finish();
    }
}
