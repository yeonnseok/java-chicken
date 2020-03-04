package view;

import domain.Menu;
import domain.Table;

import java.util.List;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";
	private static final String CHOOSE_ORDER_TABLE_GUIDE_MESSAGE = "## 주문할 테이블을 선택하세요.";
	private static final String CHOOSE_ORDER_MENU_GUIDE_MESSAGE = "## 등록할 메뉴를 선택하세요.";
	private static final String ENTER_ORDER_AMOUNT_GUIDE_MESSAGE = "## 메뉴의 수량을 입력하세요.";

	public static void askInputTableNumber() {
		System.out.println(CHOOSE_ORDER_TABLE_GUIDE_MESSAGE);
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

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
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
		String bottomLine = "└ ─ ┘";
		if (isOrdered) {
			bottomLine = "└ ₩ ┘";
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
