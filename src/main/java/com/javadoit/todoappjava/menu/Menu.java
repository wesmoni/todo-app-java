package com.javadoit.todoappjava.menu;

import java.util.Arrays;
import java.util.Optional;

/** */
public enum Menu {
    QUIT("0"),
    SHOW_LIST("1"),
    CREATE("2"),
    UPDATE("3"),
    REMOVE("4"),
    FINISH("5"),
    SEARCH("6"),
    CHECK("7");

    private String menuNumber;

    /** Сеттер для меню задач */
    Menu(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    /** Проверяет, есть ли задача в меню и если нет, то выводит сообщение об ошибке.*/
    public static Menu fromMenuNumber(String menuNumber) {
        Optional<Menu> todoMenu =
                Arrays.stream(Menu.values()).filter(e -> e.menuNumber.equals(menuNumber)).findAny();
        if (!todoMenu.isPresent()) {
            throw new IllegalArgumentException(menuNumber + " is wrong menu. try again.");
        }
        return todoMenu.get();
    }

}
