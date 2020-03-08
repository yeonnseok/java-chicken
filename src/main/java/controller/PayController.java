package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PayController implements PosController {
    final Tables tables = new Tables(TableRepository.tables());

    @Override
    public void controlAction() {
        checkEmptyTableWhenPay(tables);
        OutputView.printTables(tables);
        Table selectedTable = getPayTableWithInputValidation(tables);

        OutputView.printOrderList(selectedTable);
        OutputView.printPayProcessMessage(selectedTable);

        Payment payment = getPaymentWithValidation();
        int totalPrice = payment.totalPriceAfterPaymentDiscount(selectedTable.getTotalPrice());
        OutputView.printTotalPrice(totalPrice);
    }

    private static void checkEmptyTableWhenPay(final Tables tables) {
        if (tables.isAllEmptyOrders()) {
            throw new IllegalArgumentException("결제할 수 있는 테이블이 없습니다.");
        }
    }

    private static Table getPayTableWithInputValidation(Tables tables) {
        try {
            Table selectedTable = tables.getTableByNumber(InputView.inputPayTableNumber());
            checkOrderingTable(selectedTable);
            return selectedTable;
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPayTableWithInputValidation(tables);
        }
    }

    private static void checkOrderingTable(final Table table) {
        if (!table.hasOrders()) {
            throw new IllegalArgumentException("현재 주문 진행중인 테이블만 선택가능합니다.");
        }
    }

    private static Payment getPaymentWithValidation() {
        try {
            return Payment.getPayment(InputView.inputPaymentNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPaymentWithValidation();
        }
    }
}
