package domain;

public class TableNumber {
    private int tableNumber;

    public TableNumber(int tableNumber) {
        checkTableRange(tableNumber);
        this.tableNumber = tableNumber;
    }

    private static void checkTableRange(int tableNumber) {
        if (TableRepository.tables()
                .stream()
                .mapToInt(Table::getNumber)
                .noneMatch(number -> number == tableNumber)) {
            throw new IllegalArgumentException("선택 가능한 테이블 번호가 아닙니다.");
        }
    }
}