package com.javadoit.todoappjava.menu;

import java.util.ArrayList;
import java.util.List;

public class Parameters {

    private Menu menu;
    private Long id;
    private String content;
    private List<Long> Ids;

    /** menu, id, content, parentIds setter */
    public Parameters(Menu menu, Long id, String content, List<Long> Ids) {
        this.menu = menu;
        this.id = id;
        this.content = content;
        this.Ids = Ids;
    }

    /**
     * */
    public static Parameters parse(String input) {
        String[] parsed = input.split(" ");

        /**
         * */
        Menu menu = Menu.fromMenuNumber(parsed[0]);

        switch (menu) {
            case QUIT:
                return quit();
            case SHOW_LIST:
                return showList();
            case CREATE:
                return create(parsed);
            case UPDATE:
                return update(parsed);
            case REMOVE:
                return remove(parsed);
            case FINISH:
                return finish(parsed);
            case SEARCH:
                return search(parsed);
            case CHECK:
                return check();
            default:
                throw new IllegalStateException("Wrong menu. try again.");
        }
    }
    private static Parameters check() {
        return new Parameters(Menu.CHECK, null, null, null);
    }

    private static Parameters search(String[] parsed) {
        String content = parsed[1];
        return new Parameters(Menu.SEARCH, null, content, null);
    }

    private static Parameters finish(String[] parsed) {
        long id = Long.parseLong(parsed[1]);
        return new Parameters(Menu.FINISH, id, null, null);
    }

    private static Parameters remove(String[] parsed) {
        long id = Long.parseLong(parsed[1]);
        return new Parameters(Menu.REMOVE, id, null, null);
    }

    private static Parameters update(String[] parsed) {
        long id = Long.parseLong(parsed[1]);
        String content = parsed[2];
        List<Long> parentIds = getIds(parsed, 3);
        return new Parameters(Menu.UPDATE, id, content, parentIds);
    }

    private static Parameters create(String[] parsed) {
        String content = parsed[1];
        List<Long> parentIds = getIds(parsed, 2);
        return new Parameters(Menu.CREATE, null, content, parentIds);
    }

    private static Parameters showList() {
        return new Parameters(Menu.SHOW_LIST, null, null, null);
    }

    private static Parameters quit() {
        return new Parameters(Menu.QUIT, null, null, null);
    }

    /** Ids parser */
    private static List<Long> getIds(String[] parsed, int threshold) {
        List<Long> parents = new ArrayList<>();
        if (parsed.length > threshold) {
            for (int i = threshold; i < parsed.length; ++i) {
                parents.add(Long.parseLong(parsed[i].substring(1)));
            }
        }
        return parents;
    }

    /** menu getter */
    public Menu getMenu() {
        return menu;
    }

    /** id getter */
    public Long getId() {
        return id;
    }

    /** content getter */
    public String getContent() {
        return content;
    }

    /** Ids getter */
    public List<Long> getIds() {
        return Ids;
    }
}
