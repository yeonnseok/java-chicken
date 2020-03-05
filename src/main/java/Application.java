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
                OutputView.printTables(tables, tableNumber);
                tableNumber = inputTableNumberWithValidation(tableNumber);
                OutputView.printOrderList(orders);
                OutputView.printPayProcessMessage(tableNumber);
            }
        } while (pos != Pos.EXIT);

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

    private static TableNumber inputTableNumberWithValidation(TableNumber tableNumber) {
        try {
            int inputNumber = InputView.inputTableNumber();
            checkExistedTableNumber(tableNumber, inputNumber);
            return new TableNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumberWithValidation(tableNumber);
        }
    }

    private static void checkExistedTableNumber(TableNumber tableNumber, int inputNumber) {
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
