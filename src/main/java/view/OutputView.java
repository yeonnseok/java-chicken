package view;

import domain.*;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String SELECTED_LINE = "└ ₩ ┘";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String SPACE = " ";

    public static void printPosMenus() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final Tables tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables.getTables());
        printBottomLine(size, tables);
    }

    public static void printMenus(final Menus menus) {
        for (final Menu menu : menus.getMenus()) {
            System.out.println(menu);
        }
    }

    private static void printBottomLine(final int count, final Tables tables) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < count; index++) {
            printSelectedLine(tables, stringBuilder, index);
        }
        System.out.println(stringBuilder);
    }

    private static void printSelectedLine(final Tables tables, final StringBuilder stringBuilder, final int index) {
        if (tables.getTables().get(index).hasOrders()) {
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

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    public static void printOrderList(final Table table) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE)
                    .append("## 주문 내역")
                    .append(NEW_LINE)
                    .append("메뉴 수량 금액")
                    .append(NEW_LINE);
        printEachMenuInformation(table.getOrders(), stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void printEachMenuInformation(final Orders orders, final StringBuilder stringBuilder) {
        for (Menu menu : orders.getOrders().keySet()) {
            stringBuilder.append(menu.getName())
                        .append(SPACE)
                        .append(orders.getOrders().get(menu))
                        .append(SPACE)
                        .append(menu.getPrice())
                        .append(NEW_LINE);
        }
    }

    public static void printPayProcessMessage(final Table table) {
        System.out.println(String.format("%d번 테이블의 결제를 진행합니다.", table.getNumber()));
    }

    public static void printTotalPrice(final int totalPrice) {
        System.out.println(NEW_LINE + "## 최종 결제할 금액");
        System.out.println(String.format("%d원", totalPrice));
    }
}
