import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        final Orders orders = new Orders();
        TableNumber tableNumber = new TableNumber();
        Pos pos;
        do {
            pos = getPosWithValidation();
            if (pos == Pos.ORDER) {
                OutputView.printTables(tables, tableNumber);
                tableNumber = inputTableNumberWithValidation(tableNumber);
                OutputView.printMenus(menus);
                MenuNumber menuNumber = inputMenuNumberWithValidation();
                Count count = inputCountWithValidation();
                orders.addOrder(menuNumber.getMenuByNumber(), count);
            }

            if (pos == Pos.PAY) {
                checkEmptyTableWhenPay(pos, tableNumber);
                OutputView.printTables(tables, tableNumber);
                tableNumber = inputTableNumberWithValidation(tableNumber);
                OutputView.printOrderList(orders);
                OutputView.printPayProcessMessage(tableNumber);
                Payment payment = getPaymentWithValidation();
                int totalPrice = payment.totalPriceAfterPaymentDiscount(orders.totalPriceDiscountedByChickenCount());
                OutputView.printTotalPrice(totalPrice);
            }
        } while (pos != Pos.EXIT);

    }

    private static Payment getPaymentWithValidation() {
        try {
            return Payment.getPayment(InputView.inputPaymentNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPaymentWithValidation();
        }
    }

    private static Count inputCountWithValidation() {
        try {
            return new Count(InputView.inputCount());
        } catch(IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputCountWithValidation();
        }
    }

    private static MenuNumber inputMenuNumberWithValidation() {
        try {
            return new MenuNumber(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputMenuNumberWithValidation();
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

    private static void checkEmptyTableWhenPay(final Pos pos, final TableNumber tableNumber) {
        if (pos == Pos.PAY && tableNumber.isInitialTableNumber()) {
            throw new IllegalArgumentException("결제할 수 있는 테이블이 없습니다.");
        }
    }

    private static void checkExistedTableNumber(final TableNumber tableNumber, final int inputNumber) {
        if (tableNumber.isNotZeroAndNotSameValueWith(inputNumber)) {
            throw new IllegalArgumentException("현재 주문 진행중인 테이블만 선택가능합니다.");
        }
    }

    private static Pos getPosWithValidation() {
        try {
            return Pos.getPos(InputView.inputPosNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPosWithValidation();
        }
    }
}
