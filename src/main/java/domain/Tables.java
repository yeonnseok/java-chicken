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
                .anyMatch(t -> t.isMatchTableNumber(tableNumber));
    }

    public int calculateTotalMoney(int tableNumber) {
        return tables.stream()
                .filter(t -> t.isMatchTableNumber(tableNumber))
                .mapToInt(t -> t.calculateMenuPriceSum())
                .sum();
    }

    public int countChickenMenu(int tableNumber) {
        return tables.stream()
                .filter(t -> t.isMatchTableNumber(tableNumber))
                .mapToInt(t -> t.countChickenMenu())
                .sum();
    }

    public void initOrderList(int tableNumber) {
        tables.stream()
                .filter(t -> t.isMatchTableNumber(tableNumber))
                .forEach(t -> t.initOrderList());
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
