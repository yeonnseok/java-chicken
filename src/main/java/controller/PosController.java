package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.TableRepository;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 치킨집 포스기 컨트롤러
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class PosController {
	public void run() { // TODO: 2020/03/04 장기적으로 여기에서는 기능을 받아서 해당하는 기능으로 이동하도록, 즉 다른 메서드를 추가하기, 우선은 주문기능 여기에 구현
		while (true) {
			final Tables tables = new Tables(TableRepository.tables());

			OutputView.printTables(tables.getTables());

			final Table orderingTable = receiveOrderingTable(tables);

			final List<Menu> menus = MenuRepository.menus();
			OutputView.printMenus(menus);
			Order order = receiveOrder();
			orderingTable.order(order);
		}

	}

	private Table receiveOrderingTable(Tables tables) {
		try {
			OutputView.askInputTableNumber();
			return tables.getTable(InputView.askTableNumber());
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receiveOrderingTable(tables);
		}
	}

	private Order receiveOrder() {
		try {
			OutputView.askInputOrderMenu();
			Menu orderingMenu = MenuRepository.getMenu(InputView.askMenuNumber());
			OutputView.askInputOrderAmount();
			int orderingAmount = InputView.askAmount();
			return new Order(orderingMenu, orderingAmount);
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receiveOrder();
		}
	}


}
