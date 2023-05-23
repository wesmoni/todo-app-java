package com.javadoit.todoappjava;

import com.javadoit.todoappjava.domain.Repository;
import com.javadoit.todoappjava.menu.Menu;
import com.javadoit.todoappjava.menu.Parameters;
import com.javadoit.todoappjava.processor.Processor;

import java.util.Map;

/**
 * Команды processor выполняются в соответствии с введенным запросом.
 */
public class Console {

    private Map<Menu, Processor> ProcessorMapping;
    private Repository Repository;
    private Helper Helper;

    /** setter */
    public Console(
            Map<Menu, Processor> ProcessorMapping,
            Repository Repository,
            Helper Helper) {
        this.ProcessorMapping = ProcessorMapping;
        this.Repository = Repository;
        this.Helper = Helper;
    }

    void start() {

        Helper.printMenuWithExample();
        while (true) {
            try {
                String input = Helper.inputCommand();
                Parameters todoMenuParameter = Parameters.parse(input);
                Menu menu = todoMenuParameter.getMenu();
                if (menu == Menu.QUIT) {
                    break;
                }
                if (menu == Menu.SHOW_LIST) {
                    Helper.printTodoList(Repository.findAll());
                    continue;
                }
                if (menu == Menu.SEARCH) {
                    Helper.printMessage("Это результат поиска срдеи задач, которые Вы ввели: ["+ todoMenuParameter.getContent() + "] ");

                    Helper.printTodoList(Repository.searchAllStream(todoMenuParameter.getContent()));
                    continue;
                }
                if (menu == Menu.CHECK) {
                    Helper.printMessage("Список дел. ");
                    Helper.printTodoList(Repository.check());
                    continue;
                }
                Processor todoProcessor = ProcessorMapping.get(menu);
                todoProcessor.run(todoMenuParameter);
                Helper.printTodoList(Repository.findAll());
            } catch (Exception e) {
                Helper.printMessage(e.getMessage());
            }
        }
    }
}
