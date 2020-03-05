package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String PAY_FINISH_BOTTOM_LINE = "└ ─ ┘";
    private static final String NOT_PAY_FINISH_BOTTOM_LINE = "└ m ┘";
    private static final String NEW_LINE = System.lineSeparator();
    private static final int PAY_FINISH = 0;

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables) {
            printPayFinishTableBottomLine(table);
            printNotPayFinishTableBottomLine(table);
        }
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printPayFinishTableBottomLine(Table table) {
        if (!isPayFinish(table)) {
            printBottomLine(NOT_PAY_FINISH_BOTTOM_LINE);
        }
    }

    private static void printNotPayFinishTableBottomLine(Table table) {
        if (isPayFinish(table)) {
            printBottomLine(PAY_FINISH_BOTTOM_LINE);
        }
    }

    private static boolean isPayFinish(Table table) {
        return table.calculateMenuPriceSum() == PAY_FINISH;
    }

    private static void printBottomLine(final String line) {
        System.out.print(line);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printMain() {
        System.out.println("## 메인화면" + NEW_LINE + "1. 주문등록" + NEW_LINE + "2. 결제하기" + NEW_LINE + "3. 프로그램 종료");
    }

    public static void printInputTableNumber() {
        System.out.println(NEW_LINE + "## 주문할 테이블을 선택하세요.");
    }

    public static void printInputToDo() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printInputRegisterMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
    }

    public static void printInputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
    }
}
