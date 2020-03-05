package controller;

import domain.PaymentWay;
import domain.Tables;
import domain.TotalMoneyCalculator;
import view.InputView;
import view.OutputView;

public class PayController {
    public static void startPay(Tables tables) {
        OutputView.printTables(tables.tables());
        int tableNumber = InputView.inputTableNumber();
        OutputView.printOrderList(tables, tableNumber);
        OutputView.printStartPay(tableNumber);
        PaymentWay paymentWay = new PaymentWay(InputView.inputPaymentWay());
        int totalMoney = TotalMoneyCalculator.calculateTotalMoney(tables, tableNumber, paymentWay);
        OutputView.printTotalMoney(totalMoney);
        tables.initOrderList(tableNumber);
    }
}
