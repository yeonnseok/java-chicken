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
			OutputView.askInputPosStatus();
			posStatus = PosStatus.of(InputView.askPosStatus());
			runByStatus(posStatus);
		} while (!posStatus.isTerminated());
	}

	private void runByStatus(PosStatus posStatus) {
		if (posStatus.isTerminated()) {
			OutputView.printTerminationMessage();
			return;
		}

		if (posStatus.isOrdering()) {
			operateOrderFunction();
		}

		if(posStatus.isPaying()) {
			operatePayingFunction();
		}
	}

	private void operateOrderFunction() {
		OutputView.printTables(tables.getTables());

		final Table orderingTable = receiveTargetTable(tables);

		OutputView.printMenus(menus);
		Order order = receiveOrder();
		orderingTable.order(order);
	}

	private void operatePayingFunction() {
		OutputView.printTables(tables.getTables());
		final Table payingTable = receivePayingTable(tables);
		OutputView.printOrdersBy(payingTable);
		DiscountableByCategory categoryDiscountStrategy = ChickenDiscountStrategy.create();
		int price = categoryDiscountStrategy.discount(payingTable);

		OutputView.printTablePayingProcess(payingTable.getNumber());
		OutputView.printPaymentTypeOptions();
		PaymentType paymentType = PaymentType.of(InputView.askPaymentType());

		int finalPrice = CardDiscountStrategy.discount(price, paymentType);
		OutputView.printFinalPrice(finalPrice);
		payingTable.cleanTable();
	}

	private Table receivePayingTable(Tables tables) {
		Table targetTable = receiveTargetTable(tables);
		if (targetTable.isOrdered()) {
			return targetTable;
		}
		System.out.println("주문되지 않은 테이블 입니다.");
		return receivePayingTable(tables);
	}

	private Table receiveTargetTable(Tables tables) {
		try {
			OutputView.askInputTableNumber();
			return tables.getTable(InputView.askTableNumber());
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receiveTargetTable(tables);
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
