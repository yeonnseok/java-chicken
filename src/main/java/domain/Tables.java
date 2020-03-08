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

    private Menu matchMenu(int menuNumber) {
        return Menus.getMenus().stream()
                .filter(o -> o.isMatchMenu(menuNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블 번호입니다."));
    }

    public int calculateTotalMoney(int tableNumber) {
        return tables.stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .mapToInt(o -> o.calculateMenuPriceSum())
                .sum();
    }

    public int countChickenMenu(int tableNumber) {
        return tables.stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .mapToInt(o -> o.countChickenMenu())
                .sum();
    }

    public void initOrderList(int tableNumber) {
        tables.stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .forEach(o -> o.initOrderList());
    }

    public Bill getOrderList(int tableNumber) {
        return tables.stream()
                .filter(o -> o.isMatchTableNumber(tableNumber))
                .map(o -> o.getBill())
                .findFirst()
                .get();
    }

    public Table getTable(int inputTableNumber) {
        return tables().stream()
                .filter(t -> t.isMatchTableNumber(inputTableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블번호입니다."));
    }
}
