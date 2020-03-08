package controller;

import domain.Menu;
import domain.Menus;
import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class RegisterController {
    public static void startRegister(Tables tables, Menus menus) {
        OutputView.printTables(tables.tables());
        registerMenu(tables, menus);
    }

    private static void registerMenu(Tables tables, Menus menus) {
        try {
            Table table = getTable(tables, InputView.inputTableNumber());
            OutputView.printMenus(menus.getMenus());

            Menu menu = getMenu(menus, InputView.inputRegisterMenu());
            int menuQuantity = inputMenuQuantity();
            table.registerMenu(menu, menuQuantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            registerMenu(tables, menus);
        }
    }

    private static Table getTable(Tables tables, int inputTableNumber) {
        return tables.getTable(inputTableNumber);
    }

    private static Menu getMenu(Menus menus, int inputRegisterMenu) {
        return menus.getMenu(inputRegisterMenu);
    }

    private static int inputMenuQuantity() {
        try {
            return InputView.inputMenuQuantity();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputMenuQuantity();
        }
    }
}
