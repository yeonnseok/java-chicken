package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class OrderController implements PosController {
    @Override
    public void controlAction(Tables tables, Menus menus) {
        OutputView.printTables(tables);
        Table selectedTable = getTableWithInputValidation(tables);

        OutputView.printMenus(menus);
        Menu selectedMenu = getMenuWithInputValidation(menus);

        Quantity quantity = inputCountWithValidation();
        selectedTable.addToOrders(selectedMenu, quantity);
    }

    private static Quantity inputCountWithValidation() {
        try {
            return new Quantity(InputView.inputCount());
        } catch(IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputCountWithValidation();
        }
    }

    private static Menu getMenuWithInputValidation(Menus menus) {
        try {
            return menus.getMenuByNumber(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getMenuWithInputValidation(menus);
        }
    }

    private static Table getTableWithInputValidation(Tables tables) {
        try {
            return tables.getTableByNumber(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getTableWithInputValidation(tables);
        }
    }
}
