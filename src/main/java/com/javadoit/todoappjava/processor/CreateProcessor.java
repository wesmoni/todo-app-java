package com.javadoit.todoappjava.processor;

import com.javadoit.todoappjava.domain.IDGenerator;
import com.javadoit.todoappjava.domain.Todo;
import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Parameters;
import java.util.List;

/** Создает список дел. */
public class CreateProcessor implements Processor {

    private Repository Repository;
    private IDGenerator idGenerator;

    public CreateProcessor(Repository Repository, IDGenerator idGenerator) {
        this.Repository = Repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public void run(Parameters Parameters) {
        List<Todo> dependencies = Repository.findAll(Parameters.getIds());
        long id = idGenerator.generate();
        Todo todo = new Todo(id, Parameters.getContent(), dependencies);
        Repository.add(todo);
    }
}

