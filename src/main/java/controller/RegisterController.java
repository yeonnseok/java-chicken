package controller;

import domain.Menus;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class RegisterController {
    public static void startRegister(Tables tables, Menus menus) {
        OutputView.printTables(tables.tables());
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus.getMenus());
        int menuNumber = InputView.inputRegisterMenu();
        int menuQuantity = InputView.inputMenuQuantity();
        tables.registerMenu(tableNumber, menuNumber, menuQuantity);
    }
}
