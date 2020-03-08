package domain;

import java.util.List;

public class Tables {
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public int size() {
        return tables.size();
    }

    public Table getTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getNumber() == tableNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블 번호 입니다."));
    }

    public boolean isAllEmptyOrders() {
        return tables.stream()
                .noneMatch(Table::hasOrders);
    }
}
