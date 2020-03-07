package controller;

import domain.Menus;
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
            int tableNumber = inputTableNumber(tables);
            OutputView.printMenus(menus.getMenus());

            int menuNumber = inputMenuNumber(menus);
            int menuQuantity = inputMenuQuantity();
            tables.registerMenu(tableNumber, menuNumber, menuQuantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            registerMenu(tables, menus);
        }
    }

    private static int inputTableNumber(Tables tables) {
        try {
            int tableNumber = InputView.inputTableNumber();
            return validateTableNumber(tables, tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputTableNumber(tables);
        }
    }

    private static int validateTableNumber(Tables tables, int tableNumber) {
        if (!tables.isPresentTableNumber(tableNumber)) {
            throw new IllegalArgumentException("존재하지 않는 테이블 번호입니다.");
        }
        return tableNumber;
    }

    private static int inputMenuNumber(Menus menus) {
        try {
            int menuNumber = InputView.inputRegisterMenu();
            return validateMenuNumber(menus, menuNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputMenuNumber(menus);
        }
    }

    private static int validateMenuNumber(Menus menus, int menuNumber) {
        if (!menus.isPresentMenu(menuNumber)) {
            throw new IllegalArgumentException("존재하지 않는 음식 번호입니다.");
        }
        return menuNumber;
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
