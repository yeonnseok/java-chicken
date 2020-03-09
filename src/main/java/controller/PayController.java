package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PayController implements PosController {
    @Override
    public void execute(Tables tables, Menus menus) {
        OutputView.printTables(tables.getTables());
        Table table = selectTable(tables);
        OutputView.printOrder(table);
        PaymentType paymentType = createPaymentType();
        int totalAmount = Calculator.calculate(table, paymentType);
        OutputView.printTotalAmount(totalAmount);
        table.clearOrder();
    }

    private static Table selectTable(Tables tables) {
        try {
            int tableNumber = InputView.inputTableNumber();
            return tables.getTableByTableNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return selectTable(tables);
        }
    }

    private static PaymentType createPaymentType() {
        try {
            int paymentTypeNumber = InputView.inputPaymentType();
            return PaymentType.getPaymentType(paymentTypeNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createPaymentType();
        }
    }
}
