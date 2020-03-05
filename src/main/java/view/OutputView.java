package view;

import domain.menu.Menu;
import domain.order.Order;
import domain.table.Table;

import java.util.List;

/**
 * 출력을 담당하는 클래스
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";
	private static final String TABLE_LIST = "## 테이블 목록";
	private static final String CHOOSE_TABLE_GUIDE_MESSAGE = "## 테이블을 선택하세요.";
	private static final String CHOOSE_ORDER_MENU_GUIDE_MESSAGE = "## 등록할 메뉴를 선택하세요.";
	private static final String ENTER_ORDER_AMOUNT_GUIDE_MESSAGE = "## 메뉴의 수량을 입력하세요.";
	private static final String ORDER_CONTENTS = "## 주문내역";
	private static final String ORDER_COLUMN_NAME = "메뉴   수량   금액";
	private static final String TABLE_PAYING_PROCESS_GUIDE_MESSAGE = "## %d번 테이블의 결제를 진행합니다.\n";
	private static final String PAYMENT_OPTIONS_GUIDE_MESSAGE = "## 신용카드는 1번, 현금은 2번";
	private static final String FINAL_PRICE_IS = "## 최종 결제할 금액";
	private static final String THIS_MUCH = "%d원\n";

	private OutputView() {}

	public static void askInputTableNumber() {
		System.out.println(CHOOSE_TABLE_GUIDE_MESSAGE);
	}

	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

	public static void askInputOrderMenu() {
		System.out.println(CHOOSE_ORDER_MENU_GUIDE_MESSAGE);
	}

	public static void askInputOrderAmount() {
		System.out.println(ENTER_ORDER_AMOUNT_GUIDE_MESSAGE);
	}

	public static void printTablePayingProcess(int tableNumber) {
		System.out.printf(TABLE_PAYING_PROCESS_GUIDE_MESSAGE, tableNumber);
	}

	public static void printPaymentTypeOptions() {
		System.out.println(PAYMENT_OPTIONS_GUIDE_MESSAGE);
	}

	public static void printFinalPrice(int finalPrice) {
		System.out.println(FINAL_PRICE_IS);
		System.out.printf(THIS_MUCH, finalPrice); // TODO: 2020/03/05 naming
	}

	public static void printOrdersBy(Table table) {
		System.out.println(ORDER_CONTENTS);
		System.out.println(ORDER_COLUMN_NAME);
		for (Order order : table.getOrders().getOrders()) {
			System.out.println(order);
		}
	}

	public static void printTables(final List<Table> tables) {
		System.out.println(TABLE_LIST);
		final int size = tables.size();

		printTopLines(size);
		printTableNumbers(tables);
		printBottomLines(tables);
	}

	private static void printTopLines(final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(TOP_LINE);
		}
		System.out.println();
	}

	private static void printBottomLines(final List<Table> tables) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Table table : tables) {
			stringBuilder.append(createBottomLine(table.isOrdered()));
		}
		System.out.println(stringBuilder.toString());
		System.out.println();
	}

	private static String createBottomLine(final boolean isOrdered) {
		String bottomLine = BOTTOM_LINE;
		if (isOrdered) {
			bottomLine = ORDERED_BOTTOM_LINE;
		}
		return bottomLine;
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}
}
