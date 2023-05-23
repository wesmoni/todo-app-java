package com.javadoit.todoappjava;

import com.javadoit.todoappjava.domain.Todo;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 */
public class Helper {

    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void printMenuWithExample() {
        printMenu();
        printExample();
    }

    /** Вывод функций меню. */
    public void printMenu() {
        System.out.println("  MENU");
        System.out.println("  1: show TODO list");
        System.out.println("  2: create TODO");
        System.out.println("  3: update TODO");
        System.out.println("  4: remove TODO");
        System.out.println("  5: finish TODO");
        System.out.println("  6: search TODO");
        System.out.println("  7: check unfinished TODO");
        System.out.println("  0: exit\n");
    }

    /** Вывод примера использвания меню. */
    public void printExample() {
        System.out.println("  EXAMPLE");
        System.out.println("  1<Enter>");
        System.out.println("  2 {content} [dependencies]<Enter>");
        System.out.println("  3 {id} {content} [dependencies]<Enter>");
        System.out.println("  4 {id}<Enter>");
        System.out.println("  5 {id}<Enter>");
        System.out.println("  6 {content}<Enter>");
        System.out.println("  7<Enter>");
        System.out.println("  dependencies must be written with @ (ex. @1)\n");
    }

    /** Читает команду, введенную пользователем. */
    public String inputCommand() {
        System.out.print("$ ");
        return scanner.nextLine();
    }

    public void printTodoList(List<Todo> todoList) {
        System.out.println("| ID | Контент | Дата создания | Дата последнего изменения | Конец работы |");
        for (Todo todo : todoList) {
            String information =
                    String.join(
                            " | ",
                            String.valueOf(todo.getId()),
                            getContentWithDependencies(todo),
                            getTimes(todo));
            System.out.println("| " + information + " |");
        }
    }

    private String getContentWithDependencies(Todo todo) {
        String dependencies =
                todo.getParents().stream().map(e -> "@" + e.getId()).collect(Collectors.joining(" "));
        return String.join(" ", todo.getContent(), dependencies).trim();
    }

    private String getTimes(Todo todo) {
        return String.join(
                " | ",
                todo.getCreateAt() == null ? null : todo.getCreateAt().format(formatter),
                todo.getUpdateAt() == null ? null : todo.getCreateAt().format(formatter),
                todo.getFinishAt() == null ? null : todo.getCreateAt().format(formatter));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
