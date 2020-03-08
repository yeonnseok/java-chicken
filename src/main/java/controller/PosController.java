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
	private OrderController orderController = new OrderController();
	private PaymentController paymentController = new PaymentController();
	private Tables tables = new Tables(TableRepository.tables());
	private List<Menu> menus = MenuRepository.menus();

	public void run() {
		PosStatus posStatus;

		do {
			OutputView.printMainMessage();
			posStatus = receivePosStatus();
			runByStatus(posStatus);
		} while (!posStatus.equals(PosStatus.STATUS_TERMINATION));
	}

	private PosStatus receivePosStatus() {
		try {
			OutputView.askInputPosStatus();
			int inputPosStatus = InputView.askIntegerInput();
			return PosStatus.of(inputPosStatus);
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return receivePosStatus();
		}
	}

	private void validatePosStatus(PosStatus posStatus, boolean isTablesOrdered) {
		if (posStatus.equals(PosStatus.STATUS_PAYING) && !isTablesOrdered) {
			throw new IllegalArgumentException("주문 받은 테이블이 없는데 결제를 할 수 없습니다.");
		}
	}

	private void runByStatus(PosStatus posStatus) {
		if (posStatus.equals(PosStatus.STATUS_TERMINATION)) {
			OutputView.printTerminationMessage();
			return;
		}

		if (posStatus.equals(PosStatus.STATUS_ORDER)) {
			orderController.operateOrderFunction(tables, menus);
		}

		if (posStatus.equals(PosStatus.STATUS_PAYING)) {
			validatePosStatus(posStatus, tables.isOrderedTables());
			paymentController.operatePayingFunction(orderController, tables);
		}
	}
}
