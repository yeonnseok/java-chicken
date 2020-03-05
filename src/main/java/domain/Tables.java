package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tables {
    private final List<Table> tables = new ArrayList<>();

    public Tables() {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public boolean isPresentTableNumber(int tableNumber) {
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
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .mapToInt(o -> o.countChickenMenu())
                .sum();
    }

    public int calculateTotalMoney(int tableNumber) {
        return tables.stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .mapToInt(o -> o.calculateMenuPriceSum())
                .sum();
    }
}
