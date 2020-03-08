package controller;

import domain.payment.ChickenDiscountStrategy;
import domain.payment.DiscountableByCategory;
import domain.payment.PaymentType;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

/**
 * Payment와 관련된 입출력 및 생성 담당
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class PaymentController {
	void operatePayingFunction(OrderController orderController, Tables tables) {
		OutputView.printTables(tables.getTables());
		final Table payingTable = receivePayingTable(orderController, tables);

		OutputView.printOrdersOf(payingTable);
		DiscountableByCategory categoryDiscountStrategy = ChickenDiscountStrategy.create();
		int price = categoryDiscountStrategy.discount(payingTable);

		OutputView.printTablePayingProcess(payingTable.getNumber());
		OutputView.printPaymentTypeOptions();
		PaymentType paymentType = PaymentType.of(InputView.askIntegerInput());

		int finalPrice = paymentType.calculateDiscountedPrice(price);
		OutputView.printFinalPrice(finalPrice);
		payingTable.cleanTable();
	}

	private Table receivePayingTable(OrderController orderController, Tables tables) {
		Table targetTable = orderController.receiveTargetTable(tables);

		if (targetTable.isOrdered()) {
			return targetTable;
		}

		OutputView.printNotOrderedTable();
		return receivePayingTable(orderController, tables);
	}
}
