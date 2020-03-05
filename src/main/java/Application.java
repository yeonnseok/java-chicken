import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        Pos pos;
        do {
            pos = getPosWithValidation();
            if (pos == Pos.ORDER) {
                OutputView.printTables(tables);
                TableNumber tableNumber = inputTableNumberWithValidation();

                OutputView.printMenus(menus);
                MenuNumber menuNumber = inputMenuNumberWithValidation();
            }

        } while (pos != Pos.EXIT);

    }

    private static MenuNumber inputMenuNumberWithValidation() {
        try {
            return new MenuNumber(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputMenuNumberWithValidation();
        }
    }

    private static TableNumber inputTableNumberWithValidation() {
        try {
            return new TableNumber(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumberWithValidation();
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
