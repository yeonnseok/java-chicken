package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PayController implements PosController {
    final Tables tables = new Tables(TableRepository.tables());

    @Override
    public TableNumber controlAction(TableNumber tableNumber) {
        checkEmptyTableWhenPay(tableNumber);
        OutputView.printTables(tables, tableNumber);
        tableNumber = inputTableNumberWithValidation(tableNumber);

        Table table = tables.getTableByNumber(tableNumber);
        OutputView.printOrderList(table);
        OutputView.printPayProcessMessage(tableNumber);
        Payment payment = getPaymentWithValidation();
        int totalPrice = payment.totalPriceAfterPaymentDiscount(table.getTotalPrice());
        OutputView.printTotalPrice(totalPrice);
        return tableNumber;
    }

    private static void checkEmptyTableWhenPay(final TableNumber tableNumber) {
        if (tableNumber.isInitialTableNumber()) {
            throw new IllegalArgumentException("결제할 수 있는 테이블이 없습니다.");
        }
    }

    private static TableNumber inputTableNumberWithValidation(final TableNumber tableNumber) {
        try {
            int inputNumber = InputView.inputTableNumber();
            checkExistedTableNumber(tableNumber, inputNumber);
            return new TableNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumberWithValidation(tableNumber);
        }
    }

    private static void checkExistedTableNumber(final TableNumber tableNumber, final int inputNumber) {
        if (tableNumber.isNotZeroAndNotSameValueWith(inputNumber)) {
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
