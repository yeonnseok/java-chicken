package domain;

public class TableNumber {
    private static final int INITIAL_TABLE_NUMBER = 0;

    private int tableNumber;

    public TableNumber() {
    }

    public TableNumber(final int tableNumber) {
        checkTableRange(tableNumber);
        this.tableNumber = tableNumber;
    }

    private static void checkTableRange(final int tableNumber) {
        if (TableRepository.tables()
                .stream()
                .mapToInt(Table::getNumber)
                .noneMatch(number -> number == tableNumber)) {
            throw new IllegalArgumentException("선택 가능한 테이블 번호가 아닙니다.");
        }
    }

    public boolean isNotZeroAndNotSameValueWith(final int inputNumber) {
        return tableNumber != INITIAL_TABLE_NUMBER && tableNumber != inputNumber;
    }

    public boolean isSameWith(final int index) {
        return tableNumber == TableRepository.tables()
                .get(index)
                .getNumber();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isInitialTableNumber() {
        return tableNumber == INITIAL_TABLE_NUMBER;
    }
}
