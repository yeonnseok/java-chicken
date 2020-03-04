package domain;

import java.util.List;

public class Tables {
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public Table getTable(int tableNumber) {
        return tables.stream()
                .filter(tb -> tb.isSameTableNumber(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("테이블 번호를 다시 입력해주세요."));
    }
}
