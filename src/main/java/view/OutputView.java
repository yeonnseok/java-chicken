package view;

import domain.*;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String SELECTED_LINE = "└ ₩ ┘";

    public static void printPosMenus() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables, final TableNumber tableNumber) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(size, tableNumber);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printBottomLine(final int count, final TableNumber tableNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < count; index++) {
            printSelectedLine(tableNumber, stringBuilder, index);
        }
        System.out.println(stringBuilder);
    }

    private static void printSelectedLine(TableNumber tableNumber, StringBuilder stringBuilder, int index) {
        if (tableNumber.isSameWith(index)) {
            stringBuilder.append(SELECTED_LINE);
            return;
        }
        stringBuilder.append(BOTTOM_LINE);
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printOrderList(Orders orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        orders.getOrders()
                .forEach(System.out::println);
    }
}
