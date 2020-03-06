package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * Order와 관련된 입출력 및 생성 담당
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class OrderController {
	void operateOrderFunction(Tables tables, List<Menu> menus) {
		OutputView.printTables(tables.getTables());
		Table orderingTable = receiveTargetTable(tables);
		OutputView.printMenus(menus);

		receiveOrder(orderingTable);
	}

	Table receiveTargetTable(Tables tables) {
		try {
			OutputView.askInputTableNumber();
			return tables.getTable(InputView.askIntegerInput());
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receiveTargetTable(tables);
		}
	}

	private void receiveOrder(Table orderingTable) {
		try {
			OutputView.askInputOrderMenu();
			Menu orderingMenu = MenuRepository.getMenu(InputView.askIntegerInput());

			OutputView.askInputOrderAmount();
			int orderingAmount = InputView.askIntegerInput();

			orderingTable.order(new Order(orderingMenu, orderingAmount));
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			receiveOrder(orderingTable);
		}
	}


}
