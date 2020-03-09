package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class OrderController implements PosController {
    @Override
    public void execute(Tables tables, Menus menus) {
        OutputView.printTables(tables.getTables());
        Table table = selectTable(tables);
        OutputView.printMenus(menus.getMenus());
        Menu menu = selectMenu(menus);
        addMenu(table, menu);
    }

    private static Table selectTable(Tables tables) {
        try {
            int tableNumber = InputView.inputTableNumber();
            return tables.getTableByTableNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return selectTable(tables);
        }
    }

    private static Menu selectMenu(Menus menus) {
        try {
            int menuNumber = InputView.inputMenuNumber();
            return menus.getMenuByMenuNumber(menuNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return selectMenu(menus);
        }
    }

    private static Quantity createQuantity() {
        try {
            int quantityNumber = InputView.inputQuantity();
            return new Quantity(quantityNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createQuantity();
        }
    }

    private static void addMenu(Table table, Menu menu) {
        try {
            Quantity quantity = createQuantity();
            table.addMenu(menu, quantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            addMenu(table, menu);
        }
    }
}
