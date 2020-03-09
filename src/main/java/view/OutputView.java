package view;

import domain.Menu;
import domain.Order;
import domain.Quantity;
import domain.Table;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ORDER_LINE = "└ ₩ ┘";

    private OutputView() {
    }

    public static void printFunctionType() {
        StringBuilder sb = new StringBuilder();
        sb.append("## 메인화면\n");
        sb.append("1 - 주문등록\n");
        sb.append("2 - 결제하기\n");
        sb.append("3 - 프로그램 종료\n");
        System.out.println(sb.toString());
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("\n## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        IntStream.range(0, tables.size())
                .forEach(index -> printBottomLine(tables.get(index)));
        System.out.println();
    }

    private static void printBottomLine(Table table) {
        if (table.hasOrder()) {
            System.out.print(BOTTOM_ORDER_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
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

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printOrder(Table table) {
        System.out.println("\n## 주문 내역");
        System.out.println("메뉴 수량 금액");
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();
        for (Map.Entry<Menu, Quantity> entry : orderInfo.entrySet()) {
            printOrderInfo(entry);
        }
        System.out.println("\n## " + table.toString() + "번 테이블의 결제를 진행합니다.");
    }

    private static void printOrderInfo(Map.Entry<Menu, Quantity> entry) {
        Menu menu = entry.getKey();
        Quantity quantity = entry.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(menu.getName());
        sb.append(" ");
        sb.append(quantity.getQuantity());
        sb.append(" ");
        sb.append(menu.getPrice());
        System.out.println(sb.toString());
    }

    public static void printTotalAmount(int amount) {
        System.out.println("\n## 최종 결제할 금액");
        System.out.println(Integer.toString(amount));
        System.out.println();
    }
}
