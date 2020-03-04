package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class PosController {
	public void run() { // TODO: 2020/03/04 장기적으로 여기에서는 기능을 받아서 해당하는 기능으로 이동하도록, 즉 다른 메서드를 추가하기, 우선은 주문기능 여기에 구현
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
	}

}
