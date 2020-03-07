package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayController {
    private static final int NO_ORDER_LIST = 0;

    public static void startPay(Tables tables) {
        OutputView.printTables(tables.tables());
        int tableNumber = inputTableNumber(tables);

        OutputView.printOrderList(tables, tableNumber);
        OutputView.printStartPay(tableNumber);

        PaymentWay paymentWay = createPaymentWay();

        int totalMoney = TotalMoneyCalculator.calculateTotalMoney(tables, tableNumber, paymentWay);
        OutputView.printTotalMoney(totalMoney);

        tables.initOrderList(tableNumber);
    }

    private static int inputTableNumber(Tables tables) {
        try {
            int tableNumber = InputView.inputTableNumber();
            return validateHasOrderList(tables, tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputTableNumber(tables);
        }
    }

    private static int validateHasOrderList(Tables tables, int tableNumber) {
        int orderList = countOrderedMenus(tables, tableNumber);
        if (orderList == NO_ORDER_LIST) {
            throw new IllegalArgumentException("주문 내역이 없습니다.");
        }
        return tableNumber;
    }

    private static int countOrderedMenus(Tables tables, int tableNumber) {
        OrderList tableOrderList = tables.getOrderList(tableNumber);
        List<OrderedMenu> orderedMenus = tableOrderList.getOrderedMenus();
        return orderedMenus.size();
    }

    private static PaymentWay createPaymentWay() {
        try {
            return new PaymentWay(InputView.inputPaymentWay());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createPaymentWay();
        }
    }
}
