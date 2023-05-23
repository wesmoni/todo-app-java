package com.javadoit.todoappjava;

import com.javadoit.todoappjava.domain.IDGenerator;
import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Menu;
import com.javadoit.todoappjava.processor.CreateProcessor;
import com.javadoit.todoappjava.processor.FinishProcessor;
import com.javadoit.todoappjava.processor.Processor;
import com.javadoit.todoappjava.processor.RemoveProcessor;
import com.javadoit.todoappjava.processor.UpdateProcessor;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /** Место входа в программу. */
    public static void main(String[] args) {
        Repository Repository = new Repository();
        IDGenerator IDGenerator = new IDGenerator();

        Map<Menu, Processor> todoServicesMapping = new HashMap<>();
        todoServicesMapping.put(
                Menu.CREATE, new CreateProcessor(Repository, IDGenerator));
        todoServicesMapping.put(Menu.UPDATE, new UpdateProcessor(Repository));
        todoServicesMapping.put(Menu.REMOVE, new RemoveProcessor(Repository));
        todoServicesMapping.put(Menu.FINISH, new FinishProcessor(Repository));

        Helper Helper = new Helper();
        Console todoListConsole =
                new Console(todoServicesMapping, Repository, Helper);
        todoListConsole.start();
    }
}
