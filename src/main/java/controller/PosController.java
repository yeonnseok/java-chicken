package controller;

import domain.PosStatus;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.payment.CardDiscountStrategy;
import domain.payment.ChickenDiscountStrategy;
import domain.payment.DiscountableByCategory;
import domain.payment.PaymentType;
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
	private final Tables tables = new Tables(TableRepository.tables());
	private final List<Menu> menus = MenuRepository.menus();

	public void run() {
		PosStatus posStatus;

		do {
			OutputView.printMainMessage();
			posStatus = receivePostStatus();

			runByStatus(posStatus);
		} while (!posStatus.isTerminated());
	}

	private PosStatus receivePostStatus() {
		try {
			OutputView.askInputPosStatus();
			return PosStatus.of(InputView.askIntegerInput());
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receivePostStatus();
		}
	}

	private void runByStatus(PosStatus posStatus) {
		if (posStatus.isTerminated()) {
			OutputView.printTerminationMessage();
			return;
		}

		if (posStatus.isOrdering()) {
			operateOrderFunction();
		}

		if (posStatus.isPaying()) {
			operatePayingFunction();
		}
	}

	private void operateOrderFunction() {
		OutputView.printTables(tables.getTables());
		final Table orderingTable = receiveTargetTable(tables);
		OutputView.printMenus(menus);

		receiveOrder(orderingTable);
	}

	private void operatePayingFunction() { // TODO: 2020/03/05 너무 부하다
		OutputView.printTables(tables.getTables());
		final Table payingTable = receivePayingTable(tables);

		OutputView.printOrdersBy(payingTable);
		DiscountableByCategory categoryDiscountStrategy = ChickenDiscountStrategy.create();
		int price = categoryDiscountStrategy.discount(payingTable);

		OutputView.printTablePayingProcess(payingTable.getNumber());
		OutputView.printPaymentTypeOptions();
		PaymentType paymentType = PaymentType.of(InputView.askIntegerInput());

		int finalPrice = CardDiscountStrategy.discount(price, paymentType);
		OutputView.printFinalPrice(finalPrice);
		payingTable.cleanTable();
	}

	private Table receivePayingTable(Tables tables) {
		Table targetTable = receiveTargetTable(tables);

		if (targetTable.isOrdered()) {
			return targetTable;
		}

		OutputView.printNotOrderedTable();
		return receivePayingTable(tables);
	}

	private Table receiveTargetTable(Tables tables) {
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
