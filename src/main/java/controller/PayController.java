package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PayController implements PosController {
    @Override
    public void controlAction(Tables tables, Menus menus) {
        checkEmptyTableWhenPay(tables);
        OutputView.printTables(tables);
        Table selectedTable = getPayTableWithInputValidation(tables);

        OutputView.printOrderList(selectedTable);
        OutputView.printPayProcessMessage(selectedTable);

        Payment payment = getPaymentWithValidation();
        int totalPrice = payment.totalPriceAfterPaymentDiscount(selectedTable.getTotalPrice());
        OutputView.printTotalPrice(totalPrice);

        PayDecide payDecide = getPayDecideNumberWithValidation();
        payDecide.finalAction(selectedTable);

    }

    private static void checkEmptyTableWhenPay(final Tables tables) {
        if (tables.isAllEmptyOrders()) {
            throw new IllegalArgumentException("결제할 수 있는 테이블이 없습니다.");
        }
    }

    private static Table getPayTableWithInputValidation(Tables tables) {
        try {
            Table selectedTable = tables.getTableByNumber(InputView.inputPayTableNumber());
            return checkOrderingTable(selectedTable);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPayTableWithInputValidation(tables);
        }
    }

    private static Table checkOrderingTable(final Table table) {
        if (!table.hasOrders()) {
            throw new IllegalArgumentException("현재 주문 진행중인 테이블만 선택가능합니다.");
        }
        return table;
    }

    private static Payment getPaymentWithValidation() {
        try {
            return Payment.getPayment(InputView.inputPaymentNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPaymentWithValidation();
        }
    }

    private static PayDecide getPayDecideNumberWithValidation() {
        try {
            return PayDecide.getPayDecide(InputView.inputPayDecideNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPayDecideNumberWithValidation();
        }
    }
}
