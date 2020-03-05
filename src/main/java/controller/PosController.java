package controller;

import domain.PosStatus;
import domain.menu.Menu;
import domain.menu.MenuRepository;
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
	OrderController orderController = new OrderController();
	PaymentController paymentController = new PaymentController();
	Tables tables = new Tables(TableRepository.tables());
	List<Menu> menus = MenuRepository.menus();

	public void run() {
		PosStatus posStatus;

		do {
			OutputView.printMainMessage();
			posStatus = receivePostStatus(tables.isOrderedTables());

			runByStatus(posStatus);
		} while (!posStatus.isTerminated());
	}

	private PosStatus receivePostStatus(boolean isTablesOrdered) {
		try {
			OutputView.askInputPosStatus();
			int inputPosStatus = validatePosStatus(InputView.askIntegerInput(), isTablesOrdered);
			return PosStatus.of(inputPosStatus);
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receivePostStatus(isTablesOrdered);
		}
	}

	private int validatePosStatus(int inputPosStatus, boolean isTablesOrdered) {
		if (inputPosStatus == 2 && !isTablesOrdered) {
			throw new IllegalArgumentException("주문 받은 테이블이 없는데 결제를 할 수 없습니다.");
		}
		return inputPosStatus;
	}

	private void runByStatus(PosStatus posStatus) {
		if (posStatus.isTerminated()) {
			OutputView.printTerminationMessage();
			return;
		}

		if (posStatus.isOrdering()) {
			orderController.operateOrderFunction(tables, menus);
		}

		if (posStatus.isPaying()) {
			paymentController.operatePayingFunction(orderController, tables);
		}
	}
}
