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
			orderController.operateOrderFunction(tables, menus);
		}

		if (posStatus.isPaying()) {
			paymentController.operatePayingFunction(orderController, tables);
		}
	}
}
