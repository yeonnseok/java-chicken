package view;

import domain.menu.Menu;
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
	private static final String CHOOSE_ORDER_TABLE_GUIDE_MESSAGE = "## 주문할 테이블을 선택하세요.";
	private static final String CHOOSE_ORDER_MENU_GUIDE_MESSAGE = "## 등록할 메뉴를 선택하세요.";
	private static final String ENTER_ORDER_AMOUNT_GUIDE_MESSAGE = "## 메뉴의 수량을 입력하세요.";

	private OutputView() {}

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
