package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tables {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static boolean isPresentTableNumber(int tableNumber) {
        return tables.stream()
                .anyMatch(o -> o.isMatchTableNumber(tableNumber));
    }

    public void registerMenu(int tableNumber, Menu menu, int quantity) {
        tables().stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .forEach(o -> o.registerMenu(menu,quantity));
    }

    public int countChickenMenu(int tableNumber) {
        return tables.stream()
                .mapToInt(o -> o.countChickenMenu())
                .sum();
    }
}
