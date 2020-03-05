import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        Pos pos;
        do {
            pos = getPosWithValidation();
            if (pos == Pos.ORDER) {
                OutputView.printTables(tables);
                TableNumber tableNumber = inputTableNumberWithValidation();
            }

        } while (pos != Pos.EXIT);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
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
